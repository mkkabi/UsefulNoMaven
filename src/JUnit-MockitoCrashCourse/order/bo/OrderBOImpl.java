package orderProcessingService.order.bo;

import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import orderProcessingService.order.bo.exception.BOException;
import orderProcessingService.order.dto.Order;
import orderProcessingService.order.dao.OrderDAO;

public class OrderBOImpl implements OrderBO {

	OrderDAO dao;

	public OrderDAO getDao() {
		return dao;
	}

	public void setDao(OrderDAO o) {
		this.dao = o;
	}

	@Override
	public boolean placeOrder(Order order) throws BOException {
		try {
			int result = dao.create(order);
			if (result == 0) {
				return false;
			}
		} catch (SQLException e) {
			throw new BOException(e);
		}
		return true;
	}

	@Override
	public boolean cancelOrder(int id) throws BOException {
		try {
			Order order = dao.read(id);
			order.setStatus("cancel");
			int result = dao.update(order);
			if (result == 0) {
				return false;
			}
		} catch (SQLException e) {
			throw new BOException(e);
		}

		return true;
	}

	@Override
	public boolean deleteOrder(int id) throws BOException {
		try {
			int result = dao.delete(id);
			if (result == 0) {
				return false;
			}
		} catch (SQLException e) {
			throw new BOException(e);
		}
		return true;
	}

}
