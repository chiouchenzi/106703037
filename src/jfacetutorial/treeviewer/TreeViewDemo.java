package jfacetutorial.treeviewer;

import org.eclipse.jface.viewers.TreeViewer;
import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.FillLayout;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.List;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Tree;

import jfacetutorial.AppMenu;
import jfacetutorial.DataModel;

public class TreeViewDemo {

	protected Shell shell;

	/**
	 * Launch the application.
	 * @param args
	 */
	public static void main(String[] args) {
		try {
			TreeViewDemo window = new TreeViewDemo();
			window.open();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Open the window.
	 */
	public void open() {
		Display display = Display.getDefault();
		createContents();
		shell.open();
		shell.layout();
		while (!shell.isDisposed()) {
			if (!display.readAndDispatch()) {
				display.sleep();
			}
		}
	}

	/**
	 * Create contents of the window.
	 */
	protected void createContents() {
		shell = new Shell();
		shell.setSize(450, 300);
		shell.setText("SWT Application");
		shell.setLayout(new FillLayout(SWT.HORIZONTAL));
		
		TreeViewer treeViewer = new TreeViewer(shell, SWT.BORDER);
		Tree tree = treeViewer.getTree();
		tree.setHeaderVisible(true);
		tree.setLinesVisible(true);
		
		treeViewer.setInput(DataModel.getAppMenus());
		// Get data of TreeViewer.
		List<AppMenu> input = (List<AppMenu>)treeViewer.getInput();
		AppMenu menu = input.get(0);
		List<AppMenu> childMenus = menu.getChildren();
		// add AppMenu
		childMenus .add(newAppMenu);
		// Refresh
		treeViewer.refresh(menu );
		// or
		treeViewer.refresh();
		// Remove row similar.
		
	}
}
