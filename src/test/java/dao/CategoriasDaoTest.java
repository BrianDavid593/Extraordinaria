/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.sql.Connection;
import java.util.ArrayList;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author brian
 */
public class CategoriasDaoTest {
    
    static CategoriasDao catedao=new CategoriasDao();
    static Categoria categoria=new Categoria(18, "prueba", "prueba1");
    
    public CategoriasDaoTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of getConexion method, of class CategoriasDao.
     */
    @Test
    public void testGetConexion() {
        System.out.println("getConexion");
        
        CategoriasDao instance = new CategoriasDao();
        
        Connection expResult = null;
        
        Connection result = instance.getConexion();
        
        assertNotEquals(expResult, result);
    }

    /**
     * Test of read method, of class CategoriasDao.
     */
    @Test
    public void testRead() {
        System.out.println("read");
        Integer id = 100;
        Categoria result = catedao.read(id);
        assertEquals(result, null);
        id =1;
        result = catedao.read(id);
        assertEquals(result.getId(), id);
    }

    /**
     * Test of insert method, of class CategoriasDao.
     */
    @Test
    public void testInsert() {
        System.out.println("create");
        
        System.out.println("Borrando registro al empezar");
        catedao.delete(categoria.getId());

        int result = catedao.insert(categoria);
        assertNotNull(result);
        assertEquals(result, 1);
        
        System.out.println("Borrando registro al finalizar");
        catedao.delete(categoria.getId());
    }

    /**
     * Test of update method, of class CategoriasDao.
     */
    @Test
    public void testUpdate() {
        System.out.println("update");
             
    }

    /**
     * Test of delete method, of class CategoriasDao.
     */
    @Test
    public void testDelete() {
        System.out.println("delete");

        int result = catedao.delete(categoria.getId());
        assertEquals(result, 0);

        //SE ELIMINA EN EL INSERT MANUALMENTE
        result = catedao.delete(10);
        assertEquals(result, 1);
    }

    /**
     * Test of listar method, of class CategoriasDao.
     */
    @Test
    public void testListar() {
        System.out.println("listar");
        
        Integer pos=-10;
        
        ArrayList <Categoria> result=new ArrayList<>();
        
        result=catedao.listar(pos);
        
        assertNotNull(result);
        
       pos=0;
       result=catedao.listar(pos);
       assertNotNull(result);
    }
    
}
