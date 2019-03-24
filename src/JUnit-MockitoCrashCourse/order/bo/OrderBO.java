
package orderProcessingService.order.bo;

import orderProcessingService.order.bo.exception.BOException;
import orderProcessingService.order.dto.Order;

public interface OrderBO {
	boolean placeOrder(Order order) throws BOException;
	boolean cancelOrder(int id) throws BOException;
	boolean deleteOrder(int id) throws BOException;
}
