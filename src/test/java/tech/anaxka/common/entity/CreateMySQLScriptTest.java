package tech.anaxka.common.entity;

import javax.persistence.EntityManager;
import org.testng.annotations.Test;

import static javax.persistence.Persistence.createEntityManagerFactory;
import static org.testng.Assert.assertNotNull;

@Test(enabled = false)
public class CreateMySQLScriptTest {
    
    public CreateMySQLScriptTest() {
    }
    
    @Test(enabled = false)
    public void createSQLScripts() {
        final EntityManager __manager = createEntityManagerFactory("MySQLddlPU").createEntityManager();
        assertNotNull(__manager);
        __manager.close();
    }
}
