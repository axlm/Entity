package tech.anaxka.common.entity;

import javax.persistence.EntityManager;
import javax.persistence.Persistence;
import org.testng.Assert;
import org.testng.annotations.Test;

public class CreateMySQLScriptTest {
    
    public CreateMySQLScriptTest() {
    }
    
    @Test
    public void createSQLScripts() {
        final EntityManager __manager = Persistence.createEntityManagerFactory("MySQLddlPU").createEntityManager();
        Assert.assertNotNull(__manager);
        __manager.close();
    }
}
