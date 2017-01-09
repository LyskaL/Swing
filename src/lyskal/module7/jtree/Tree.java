package lyskal.module7.jtree;

import java.awt.BorderLayout;

import javax.swing.*;
import javax.swing.tree.*;

public class Tree {
	
	public Tree() {
		JFrame frame = getFrame();
		DefaultMutableTreeNode root = new DefaultMutableTreeNode("Food");
		root.add(createFruitTree());
		root.add(createVegetablesTree());
		JTree tree = new JTree(root);
		JScrollPane scroll = new JScrollPane(tree);
		frame.add(scroll, BorderLayout.CENTER);
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
		JFrame frame = new JFrame("Tree");
		frame.setBounds(500, 200, 300, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
		return frame;
	}

	public static void main(final String[] args) {
		SwingUtilities.invokeLater(new Runnable() {
			@Override
			public void run() {
				new Tree();
			}
		});
	}

}
