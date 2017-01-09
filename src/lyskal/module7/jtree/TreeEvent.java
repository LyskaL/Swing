package lyskal.module7.jtree;

import javax.swing.*;
import javax.swing.event.*;
import javax.swing.tree.*;
import java.awt.*;

public class TreeEvent {
	private JLabel label = new JLabel();
	private JTree tree;
	
	public TreeEvent() {
		JFrame frame = getFrame();
		DefaultMutableTreeNode root = new DefaultMutableTreeNode("Food");
		root.add(createFruitTree());
		root.add(createVegetablesTree());
		
		tree = new JTree(root);
		tree.setEditable(true);
		TreeSelectionModel model = tree.getSelectionModel();
		model.setSelectionMode(TreeSelectionModel.SINGLE_TREE_SELECTION);
		JScrollPane scroll = new JScrollPane(tree);
		setTreeExpansionListener();
		setTreeSelectionListener();
		setTreeModelListener();
		
		frame.add(scroll, BorderLayout.CENTER);
		frame.add(label, BorderLayout.SOUTH);
	}
	
	private void setTreeModelListener() {
		tree.getModel().addTreeModelListener(new TreeModelListener() {
			@Override
			public void treeNodesChanged(final TreeModelEvent e) {
				TreePath path = e.getTreePath();
				label.setText("Model change path: " + path);
			}
			@Override
			public void treeStructureChanged(final TreeModelEvent e) {}
			@Override
			public void treeNodesRemoved(final TreeModelEvent e) {}
			@Override
			public void treeNodesInserted(final TreeModelEvent e) {}
		});
		
	}

	private void setTreeSelectionListener() {
		tree.addTreeSelectionListener(new TreeSelectionListener() {
			@Override
			public void valueChanged(final TreeSelectionEvent e) {
				TreePath path = e.getPath();
				label.setText("Selection event: " + path.getLastPathComponent());
			}
		});
		
	}

	private void setTreeExpansionListener() {
		tree.addTreeExpansionListener(new TreeExpansionListener() {
			@Override
			public void treeExpanded(final TreeExpansionEvent event) {
				TreePath path = event.getPath();
				label.setText("Expansion: " + path.getLastPathComponent());
				
			}
			@Override
			public void treeCollapsed(final TreeExpansionEvent event) {
				TreePath path = event.getPath();
				label.setText("Collapse: " + path.getLastPathComponent());
			}
		});
		
	}

	private DefaultMutableTreeNode createVegetablesTree() {
		DefaultMutableTreeNode veg = new DefaultMutableTreeNode("Vegetables");
		veg.add(new DefaultMutableTreeNode("Beans"));
		veg.add(new DefaultMutableTreeNode("Corn"));
		veg.add(new DefaultMutableTreeNode("Potatoes"));
		veg.add(new DefaultMutableTreeNode("Rice"));
		return veg;
	}

	public DefaultMutableTreeNode createFruitTree(){
		DefaultMutableTreeNode fruit = new DefaultMutableTreeNode("Fruit");
		DefaultMutableTreeNode apples = new DefaultMutableTreeNode("Appels");
		fruit.add(apples);
		apples.add(new DefaultMutableTreeNode("Janathan"));
		apples.add(new DefaultMutableTreeNode("Winesap"));
		DefaultMutableTreeNode pears = new DefaultMutableTreeNode("Pears");
		fruit.add(pears);
		pears.add(new DefaultMutableTreeNode("Bartlett"));
		return fruit;
	}
	
	public JFrame getFrame() {
		JFrame frame = new JFrame("Tree Event");
		frame.setBounds(500, 200, 300, 350);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
		return frame;
	}

	public static void main(final String[] args) {
		SwingUtilities.invokeLater(new Runnable() {
			@Override
			public void run() {
				new TreeEvent();
			}
		});
	}

}