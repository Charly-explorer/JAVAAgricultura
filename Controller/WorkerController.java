package Controller;

import Model.Workers.Workers;
import Model.Workers.WorkersDTO;
import Model.Workers.WorkersDao;
import Model.Workers.WorkersMapper;
import View.IView;
import java.sql.SQLException;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

/**
 *
 * @author carlo
 */
public class WorkerController {
    private WorkersDao workerDao;
    private final IView view;
    private final WorkersMapper mapper;

    public WorkerController(IView view) {
        this.view = view;
        this.mapper = new WorkersMapper();
        try {
            this.workerDao = new WorkersDao(DataBase.DataBase.getConnetion());
        } catch (SQLException ex) {
            view.showError("Error al conectarse con la base de datos");
        }
    }

    public void create(Workers worker) {
        if (worker == null || !validateWorker(worker)) {
            view.showError("Faltan datos por ingresar");
            return;
        }
        try {
            if (!validatePK(worker.getIdCard())) {
                view.showError("El ID del trabajador ya está ingresado");
                return;
            }
            workerDao.create(mapper.toDto(worker));
            view.showMessage("Datos guardados correctamente");
        } catch (SQLException ex) {
            view.showError("Ocurrió un error al guardar los datos: " + ex.getMessage());
        }
    }

    public void read(Workers worker) {
        if (worker == null || worker.getIdCard() == null || worker.getIdCard().trim().isEmpty()) {
            view.showError("No hay ningún trabajador cargado actualmente");
            return;
        }
        try {
            if (validatePK(worker.getIdCard())) {
                view.showError("El ID del trabajador no está en la Base de Datos");
                return;
            }
            Workers fetchedWorker = mapper.toEnt(workerDao.read(worker.getIdCard()));
            view.show(worker); // Asume que el view tiene un método para mostrar un solo objeto
        } catch (SQLException ex) {
            view.showError("Ocurrió un error al cargar los datos: " + ex.getMessage());
        }
    }

    public void readAll() {
        try {
            List<WorkersDTO> dtoList = workerDao.readAll();
            List<Workers> workers = dtoList.stream()
                    .map(mapper::toEnt)
                    .filter(Objects::nonNull)
                    .collect(Collectors.toList());
            view.showAll(workers);
        } catch (SQLException ex) {
            view.showError("Error al cargar los datos: " + ex.getMessage());
        }
    }

    public void delete(Workers worker) {
        if (worker == null || worker.getIdCard() == null || worker.getIdCard().trim().isEmpty()) {
            view.showError("No hay ningún trabajador cargado actualmente");
            return;
        }
        try {
            if (validatePK(worker.getIdCard())) {
                view.showError("El ID del trabajador no está en la Base de Datos");
                return;
            }
            workerDao.delete(worker.getIdCard());
            view.showMessage("Trabajador eliminado correctamente");
        } catch (SQLException ex) {
            view.showError("Ocurrió un error al eliminar los datos: " + ex.getMessage());
        }
    }

    public void update(Workers worker) {
        if (worker == null || !validateWorker(worker)) {
            view.showError("Faltan datos requeridos");
            return;
        }
        try {
            if (validatePK(worker.getIdCard())) {
                view.showError("El ID del trabajador no está en la Base de Datos");
                return;
            }
            workerDao.update(mapper.toDto(worker));
            view.showMessage("Datos actualizados correctamente");
        } catch (SQLException ex) {
            view.showError("Ocurrió un error al actualizar los datos: " + ex.getMessage());
        }
    }

    public boolean validateWorker(Workers worker) {
        return worker.getIdCard() != null && !worker.getIdCard().trim().isEmpty() &&
               worker.getName() != null && !worker.getName().trim().isEmpty() &&
               worker.getLastName1() != null && !worker.getLastName1().trim().isEmpty() &&
               worker.getLastName2() != null && !worker.getLastName2().trim().isEmpty() &&
               worker.getTelephone() != null && worker.validarTelefono(worker.getTelephone()) &&
               worker.getEmail() != null && worker.validarCorreo(worker.getEmail()) &&
               worker.getPosition() != null && !worker.getPosition().trim().isEmpty() &&
               worker.getSchedule() != null && !worker.getSchedule().trim().isEmpty() &&
               worker.getSalary() > 0;
    }

    public boolean validatePK(String idCard) {
        try {
            return workerDao.validatePk(idCard);
        } catch (SQLException ex) {
            return false;
        }
    }
}

