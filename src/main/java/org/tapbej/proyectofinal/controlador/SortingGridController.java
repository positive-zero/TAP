package org.tapbej.proyectofinal.controlador;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Text;
import org.tapbej.proyectofinal.modelo.GeneradorDatos;
import org.tapbej.proyectofinal.modelo.SortMethod;
import org.tapbej.proyectofinal.modelo.SortingChart;


public class SortingGridController extends Controller
{
	@FXML
	private GridPane gridPane;

	@FXML
	private TextField txtDataQuantity;

	@FXML
	private TextField txtMillis;

	@FXML
	private Button btnBack;

	private SortingChart[] sortingChartsSelectionSort;
	private SortingChart[] sortingChartsBubbleSort;
	private SortingChart[] sortingChartsShakerSort;
	private SortingChart[] sortingChartsInsertionSort;
	private SortingChart[] sortingChartsQuickSort;

	private int interval = 200;
	private int size = 50;

	@Override
	void setKeyListener()
	{
	}

	@Override
	void setDefaultCloseOperation()
	{
	}

	@Override
	void runSpecificOperations()
	{
	}

	@FXML
	public void initialize()
	{
		drawCharts();
	}

	public void drawCharts()
	{
		int[] dataBestCase = GeneradorDatos.mejorCaso(size);
		int[] dataWorstCase = GeneradorDatos.peorCaso(size);
		int[] dataRandomCase = GeneradorDatos.casoPromedio(size);
		int[] dataMixedCase = GeneradorDatos.casoMixto(size, 50);

		int rowBestCase = 1;
		int rowWorstCase = 2;
		int rowMixedCase = 3;
		int rowRandomCase = 4;

		int columnSelectionSort = 1;
		int columnBubbleSort = 2;
		int columnShakerSort = 3;
		int columnInsertionSort = 4;
		int columnQuickSort = 5;


		// Selection sort
		sortingChartsSelectionSort = new SortingChart[4];

		sortingChartsSelectionSort[0] = new SortingChart(dataBestCase, SortMethod.SELECTION_SORT);
		gridPane.add(sortingChartsSelectionSort[0], columnSelectionSort, rowBestCase);

		sortingChartsSelectionSort[1] = new SortingChart(dataWorstCase, SortMethod.SELECTION_SORT);
		gridPane.add(sortingChartsSelectionSort[1], columnSelectionSort, rowWorstCase);

		sortingChartsSelectionSort[2] = new SortingChart(dataRandomCase, SortMethod.SELECTION_SORT);
		gridPane.add(sortingChartsSelectionSort[2], columnSelectionSort, rowRandomCase);

		sortingChartsSelectionSort[3] = new SortingChart(dataMixedCase, SortMethod.SELECTION_SORT);
		gridPane.add(sortingChartsSelectionSort[3], columnSelectionSort, rowMixedCase);


		// Bubble sort
		sortingChartsBubbleSort = new SortingChart[4];

		sortingChartsBubbleSort[0] = new SortingChart(dataBestCase, SortMethod.BUBBLE_SORT);
		gridPane.add(sortingChartsBubbleSort[0], columnBubbleSort, rowBestCase);

		sortingChartsBubbleSort[1] = new SortingChart(dataWorstCase, SortMethod.BUBBLE_SORT);
		gridPane.add(sortingChartsBubbleSort[1], columnBubbleSort, rowWorstCase);

		sortingChartsBubbleSort[2] = new SortingChart(dataRandomCase, SortMethod.BUBBLE_SORT);
		gridPane.add(sortingChartsBubbleSort[2], columnBubbleSort, rowRandomCase);

		sortingChartsBubbleSort[3] = new SortingChart(dataMixedCase, SortMethod.BUBBLE_SORT);
		gridPane.add(sortingChartsBubbleSort[3], columnBubbleSort, rowMixedCase);



		// Shaker sort
		sortingChartsShakerSort = new SortingChart[4];

		sortingChartsShakerSort[0] = new SortingChart(dataBestCase, SortMethod.SHAKER_SORT);
		gridPane.add(sortingChartsShakerSort[0], columnShakerSort, rowBestCase);

		sortingChartsShakerSort[1] = new SortingChart(dataWorstCase, SortMethod.SHAKER_SORT);
		gridPane.add(sortingChartsShakerSort[1], columnShakerSort, rowWorstCase);

		sortingChartsShakerSort[2] = new SortingChart(dataRandomCase, SortMethod.SHAKER_SORT);
		gridPane.add(sortingChartsShakerSort[2], columnShakerSort, rowRandomCase);

		sortingChartsShakerSort[3] = new SortingChart(dataMixedCase, SortMethod.SHAKER_SORT);
		gridPane.add(sortingChartsShakerSort[3], columnShakerSort, rowMixedCase);


		// Insertion sort
		sortingChartsInsertionSort = new SortingChart[4];

		sortingChartsInsertionSort[0] = new SortingChart(dataBestCase, SortMethod.INSERTION_SORT);
		gridPane.add(sortingChartsInsertionSort[0], columnInsertionSort, rowBestCase);

		sortingChartsInsertionSort[1] = new SortingChart(dataWorstCase, SortMethod.INSERTION_SORT);
		gridPane.add(sortingChartsInsertionSort[1], columnInsertionSort, rowWorstCase);

		sortingChartsInsertionSort[2] = new SortingChart(dataRandomCase, SortMethod.INSERTION_SORT);
		gridPane.add(sortingChartsInsertionSort[2], columnInsertionSort, rowRandomCase);

		sortingChartsInsertionSort[3] = new SortingChart(dataMixedCase, SortMethod.INSERTION_SORT);
		gridPane.add(sortingChartsInsertionSort[3], columnInsertionSort, rowMixedCase);

		// Quick sort
		sortingChartsQuickSort = new SortingChart[4];

		sortingChartsQuickSort[0] = new SortingChart(dataBestCase, SortMethod.QUICK_SORT);
		gridPane.add(sortingChartsQuickSort[0], columnQuickSort, rowBestCase);

		sortingChartsQuickSort[1] = new SortingChart(dataWorstCase, SortMethod.QUICK_SORT);
		gridPane.add(sortingChartsQuickSort[1], columnQuickSort, rowWorstCase);

		sortingChartsQuickSort[2] = new SortingChart(dataRandomCase, SortMethod.QUICK_SORT);
		gridPane.add(sortingChartsQuickSort[2], columnQuickSort, rowRandomCase);

		sortingChartsQuickSort[3] = new SortingChart(dataMixedCase, SortMethod.QUICK_SORT);
		gridPane.add(sortingChartsQuickSort[3], columnQuickSort, rowMixedCase);

	}

	public void handleBack()
	{
//		stopSorting();
		mainApp.showTopicSelectionView();
		mainApp.getSecondaryStage().close();
	}

	public void handleSort()
	{
		interval = Integer.parseInt(txtMillis.getText());
		size = Integer.parseInt(txtDataQuantity.getText());
		drawCharts();

		for (SortingChart sortingChart: sortingChartsSelectionSort)
			sortingChart.sort(interval);

		for (SortingChart sortingChart: sortingChartsBubbleSort)
			sortingChart.sort(interval);

		for (SortingChart sortingChart: sortingChartsShakerSort)
			sortingChart.sort(interval);

		for (SortingChart sortingChart: sortingChartsInsertionSort)
			sortingChart.sort(interval);

//		for (SortingChart sortingChart: sortingChartsQuickSort)
//			sortingChart.sort(interval);
	}

	public void stopSorting()
	{
		for (SortingChart sortingChart: sortingChartsSelectionSort)
			sortingChart.stopSorting();

		for (SortingChart sortingChart: sortingChartsBubbleSort)
			sortingChart.stopSorting();

		for (SortingChart sortingChart: sortingChartsShakerSort)
			sortingChart.stopSorting();

		for (SortingChart sortingChart: sortingChartsInsertionSort)
			sortingChart.stopSorting();

//		for (SortingChart sortingChart: sortingChartsQuickSort)
//			sortingChart.stopSorting();
	}


}