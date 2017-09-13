package com.chen.compute;

import java.io.IOException;

import tech.tablesaw.api.IntColumn;
import tech.tablesaw.api.QueryHelper;
import tech.tablesaw.api.Table;
import tech.tablesaw.columns.Column;
import tech.tablesaw.columns.ColumnReference;
import tech.tablesaw.filtering.Filter;
import tech.tablesaw.reducing.functions.Mean;
import tech.tablesaw.reducing.functions.Sum;
import tech.tablesaw.table.Projection;
import tech.tablesaw.util.Selection;

public class TableSawTest {
	public static void main(String[] args) throws IOException {
		TableSawTest t = new TableSawTest();
		t.testFilter();
	}
	
	public void testFilter()throws IOException {
		Table table = Table.read().csv("C:\\Users\\chengchen2\\Documents\\dumps\\Dump20170913\\test.csv");
		ColumnReference statusRef = QueryHelper.column("name");
		table = table.selectWhere(statusRef.contains("b"));
		Projection select = table.select("name");
		System.out.println(select.where(statusRef.contains("b")));
		
	}

	public void testSort() throws IOException {
		Table table = Table.read().csv("C:\\Users\\chengchen2\\Documents\\dumps\\Dump20170913\\test.csv");
		table = table.sortOn("name");
		System.out.println(table);
	}
	
	public void testMeanMax() throws IOException {
		Table table = Table.read().csv("C:\\Users\\chengchen2\\Documents\\dumps\\Dump20170913\\test.csv");
		table.sortDescendingOn("name");
		System.out.println(table);
		Sum sum = table.sum("id");
		Mean mean = table.mean("id");
		System.out.println("mean = "+mean.get());
		System.out.println(sum.get());
	}

	public Table test1() throws IOException {
		Table table = Table.read().csv("C:\\Users\\chengchen2\\Documents\\dumps\\Dump20170913\\test.csv");
		Table ta2 = table.first(2);
		System.out.println(table.name());
		System.out.println(table.columnCount());
		System.out.println(table.rowCount());
		System.out.println();

		table.addColumn();

		System.out.println(table);
		System.out.println(table.shape());
		System.out.println("---------------------------------");
		Column column = table.column(1);
		System.out.println(column.getString(1));

		System.out.println("---------------------------------");
		column.setName("test");
		System.out.println(column.metadata());
		// table.addColumn(column);

		System.out.println(table);
		System.out.println(table.shape());
		return table;
	}
}
