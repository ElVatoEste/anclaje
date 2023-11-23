package customidentifiers;

import model.Agenda;
import model.Student;
import org.hibernate.HibernateException;
import org.hibernate.engine.spi.SharedSessionContractImplementor;
import org.hibernate.id.IdentifierGenerator;
import service.ImplIDAO;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import java.util.List;

public class AgendaIdGenerator extends ImplIDAO implements IdentifierGenerator {

    @Override
    public Serializable generate(SharedSessionContractImplementor sharedSessionContractImplementor, Object obj)
            throws HibernateException {
        try {
            String CIF = ((Student) obj).getCIF();

            List<Agenda> studentEvents = getAll("SELECT a FROM Agenda a WHERE a.student.CIF = :CIF", Agenda.class);
            Integer count = (Integer) studentEvents.size(); // Se obtiene la cantidad entera de registros que coinciden con el CIF del estudiante en sesión

            String num = String.valueOf(count + 1); // Se incrementa la cantidad de registros a + 1, por la inserción del nuevo registro

            String currentDate = LocalDate.now().format(DateTimeFormatter.ofPattern("ddMMyyyy")); // Se obtiene la fecha actual en el formato dd/mm/aaaa

            // Se crea la estructura del nuevo ID
            String identifier;
            identifier = count + "-" + CIF + "-" + currentDate;

            return identifier;
        } catch (HibernateException e){
            throw new HibernateException("Error al generar id para Agenda: ", e);
        }
    }
}