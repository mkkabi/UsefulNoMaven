package orderProcessingService.order.bo;

import java.sql.SQLException;
import orderProcessingService.order.bo.exception.BOException;
import orderProcessingService.order.dao.OrderDAO;
import orderProcessingService.order.dto.Order;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import static org.mockito.Mockito.*;

public class OrderBOImplTest {

    @Mock
    private OrderDAO dao;
    private OrderBOImpl bo;
    private final int ORDER_ID = 123;

    @Before
    public void setup() {
        MockitoAnnotations.initMocks(this);
        bo = new OrderBOImpl();
        bo.setDao(dao);
    }

    @Test
    public void placeOrder_Shourd_Create_An_Order() throws SQLException, BOException {

        Order order = new Order();
        
        // instead of passing an instance of a class(Order in our case) we can pass a reference to class with any() matcher
        when(dao.create(any(Order.class))).thenReturn(new Integer(1));

        boolean result = bo.placeOrder(order);

        assertTrue(result);
        verify(dao).create(order);
    }

    @Test
    public void placeOrder_Should_NOT_Create_An_Order() throws SQLException, BOException {

        Order order = new Order();
        when(dao.create(order)).thenReturn(new Integer(0));
        boolean result = bo.placeOrder(order);
        assertFalse(result);
        verify(dao).create(order);
    }

    @Test(expected = BOException.class)
    public void placeOrder_Should_Throw_BOException() throws SQLException, BOException {

        Order order = new Order();
        when(dao.create(order)).thenThrow(SQLException.class);
        boolean result = bo.placeOrder(order);
    }

    @Test
    public void cancelOrder_Should_CancelOrder() throws SQLException, BOException {

        Order order = new Order();
        when(dao.read(ORDER_ID)).thenReturn(order);
        when(dao.update(order)).thenReturn(1);
        boolean result = bo.cancelOrder(ORDER_ID);

        assertTrue(result);

        verify(dao).read(ORDER_ID);
        verify(dao).update(order);
    }

    @Test
    public void cancelOrder_Should_NOT_CancelOrder() throws SQLException, BOException {

        Order order = new Order();
        when(dao.read(ORDER_ID)).thenReturn(order);
        when(dao.update(order)).thenReturn(0);
        boolean result = bo.cancelOrder(ORDER_ID);

        assertFalse(result);

        verify(dao).read(ORDER_ID);
        verify(dao).update(order);
    }

    @Test(expected = BOException.class)
    public void cancelOrder_throwBOExceptionOnRead() throws SQLException, BOException {

        when(dao.read(ORDER_ID)).thenThrow(SQLException.class);
        bo.cancelOrder(ORDER_ID);
    }

    @Test(expected = BOException.class)
    public void cancelOrder_Should_throw_BOException_on_Update() throws SQLException, BOException {

        Order order = new Order();
        when(dao.read(ORDER_ID)).thenReturn(order);
        when(dao.update(order)).thenThrow(SQLException.class);
        bo.cancelOrder(ORDER_ID);
    }
    
    @Test
    public void deteleOrder_Deletes_Order() throws BOException, SQLException{
        when(dao.delete(ORDER_ID)).thenReturn(1);
        boolean result = bo.deleteOrder(ORDER_ID);
        assertTrue(result);
        verify(dao, times(1)).delete(ORDER_ID);
    }
    
    public void foo(){
        System.out.println("foo called");
    }

}
