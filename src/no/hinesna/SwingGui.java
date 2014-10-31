package no.hinesna;

import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by christerhansen on 31.10.14.
 */
public class SwingGui extends JFrame{

    private JPanel rootPanel;
    private JList list1;
    private JTextField fornavnTxt;
    private JTextField etternavnTxt;
    private JLabel sliderLbl;
    private JButton leggTilButton;
    private JSlider alderSlider;
    private DefaultListModel<Person> model = new DefaultListModel<Person>();

    public SwingGui(){
        super("Person");
        setContentPane(rootPanel);
        pack();
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
        list1.setModel(model);
        list1.setCellRenderer(new PersonListRenderer());
        sliderLbl.setText(alderSlider.getValue()+"");

        leggTilButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                model.addElement(new Person(fornavnTxt.getText(), etternavnTxt.getText(), alderSlider.getValue()));
            }
        });

        alderSlider.addChangeListener(new ChangeListener() {
            @Override
            public void stateChanged(ChangeEvent e) {
                sliderLbl.setText(alderSlider.getValue()+"");
            }
        });
    }
}

class PersonListRenderer extends JLabel implements ListCellRenderer{

    @Override
    public Component getListCellRendererComponent(JList list, Object value, int index, boolean isSelected, boolean cellHasFocus) {

        Person person = (Person)value;
        setText(person.getFornavn()+", "+person.getEtternavn()+" - "+person.getAlder());

        return this;
    }
}