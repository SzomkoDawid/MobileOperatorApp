import model.Address;
import model.User;
import view.MainView;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class RunnerClass {
    private static final MainView MAIN_VIEW = new MainView();
    private static final User USER = new User();
    private static final Address ADDRESS = new Address();

    public static void main(String[] args) {
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("mySQL");
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        MAIN_VIEW.view(entityManager, USER, ADDRESS);
        entityManagerFactory.close();
        System.exit(0);
    }
}
