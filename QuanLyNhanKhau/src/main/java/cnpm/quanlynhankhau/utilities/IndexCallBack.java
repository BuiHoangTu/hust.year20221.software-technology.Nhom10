package cnpm.quanlynhankhau.utilities;

import javafx.beans.property.ReadOnlyObjectWrapper;
import javafx.beans.value.ObservableValue;
import javafx.scene.control.TableColumn;
import javafx.util.Callback;

public class IndexCallBack<S> implements Callback<
			TableColumn.CellDataFeatures<S, Integer>,
			ObservableValue<Integer>> {
	@Override
	public ObservableValue<Integer> call(TableColumn.CellDataFeatures<S, Integer> diaDiemIntegerCellDataFeatures) {
		return new ReadOnlyObjectWrapper<>(diaDiemIntegerCellDataFeatures.getTableView().getItems().indexOf(diaDiemIntegerCellDataFeatures.getValue()) + 1);
	}
}
