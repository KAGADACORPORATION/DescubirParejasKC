package vista;

import javax.swing.JPanel;
import java.awt.FlowLayout;
import java.awt.Panel;
import javax.swing.JButton;
import javax.swing.BoxLayout;
import java.awt.BorderLayout;
import javax.swing.JLabel;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import control.Dificultad;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.awt.Color;

public class PanelInicio extends JPanel {

	/**
	 * Create the panel.
	 * COMBOBOX, ETIQUETA Y BOTON JUGAR.
	 */
	public PanelInicio() {
		setBackground(new Color(255, 255, 153));
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0};
		gridBagLayout.rowHeights = new int[] {30, 30, 30, 0, 30, 0, 0, 30, 30};
		gridBagLayout.columnWeights = new double[]{0.0, 1.0, 0.0, 1.0, 1.0, 1.0, 0.0, 1.0, Double.MIN_VALUE};
		gridBagLayout.rowWeights = new double[]{0.0, 0.0, 0.0, 1.0, 0.0, 1.0, 1.0, 0.0, 0.0};
		setLayout(gridBagLayout);
		
		JLabel lblBusca = new JLabel("BUSCA ");
		lblBusca.setFont(new Font("Mistral", Font.PLAIN, 23));
		GridBagConstraints gbc_lblBusca = new GridBagConstraints();
		gbc_lblBusca.insets = new Insets(0, 0, 5, 5);
		gbc_lblBusca.gridx = 3;
		gbc_lblBusca.gridy = 3;
		add(lblBusca, gbc_lblBusca);
		
		JLabel lblParejas = new JLabel("PAREJAS");
		lblParejas.setFont(new Font("Showcard Gothic", Font.PLAIN, 22));
		GridBagConstraints gbc_lblParejas = new GridBagConstraints();
		gbc_lblParejas.insets = new Insets(0, 0, 5, 5);
		gbc_lblParejas.gridx = 4;
		gbc_lblParejas.gridy = 3;
		add(lblParejas, gbc_lblParejas);
		
		JLabel lblNewLabel = new JLabel("Dificultad\r\n");
		lblNewLabel.setFont(new Font("Forte", Font.PLAIN, 14));
		GridBagConstraints gbc_lblNewLabel = new GridBagConstraints();
		gbc_lblNewLabel.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel.gridx = 1;
		gbc_lblNewLabel.gridy = 5;
		add(lblNewLabel, gbc_lblNewLabel);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setModel(new DefaultComboBoxModel(Dificultad.values()));
		GridBagConstraints gbc_comboBox = new GridBagConstraints();
		gbc_comboBox.anchor = GridBagConstraints.NORTH;
		gbc_comboBox.insets = new Insets(0, 0, 5, 5);
		gbc_comboBox.gridx = 1;
		gbc_comboBox.gridy = 6;
		add(comboBox, gbc_comboBox);
		
		JButton btnJugar = new JButton("JUGAR");
		GridBagConstraints gbc_btnJugar = new GridBagConstraints();
		gbc_btnJugar.anchor = GridBagConstraints.NORTH;
		gbc_btnJugar.insets = new Insets(0, 0, 5, 5);
		gbc_btnJugar.fill = GridBagConstraints.HORIZONTAL;
		gbc_btnJugar.gridx = 6;
		gbc_btnJugar.gridy = 6;
		add(btnJugar, gbc_btnJugar);

	}
}
