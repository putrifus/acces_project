package bdd;

import java.sql.Connection;
import java.util.ArrayList;

import badge.Badge;
import javafx.collections.ObservableList;

public abstract class DAOManager<T> {
	protected Connection connect = CoSQL.getInstance();

	public abstract StringBuffer find(StringBuffer strb);

	public abstract T create();

	public abstract T update(T obj);

	public abstract void delete(T obj);

	public abstract ObservableList<T> importation();
}
