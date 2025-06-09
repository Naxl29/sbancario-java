/**~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 * Universidad de los Andes (Bogot� - Colombia)
 * Departamento de Ingenier�a de Sistemas y Computaci�n 
 * Licenciado bajo el esquema Academic Free License version 2.1 
 *
 * Proyecto Cupi2 (http://cupi2.uniandes.edu.co)
 * Ejercicio: n1_simuladorBancario
 * Autor: Equipo Cupi2 2017
 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~ 
 */
package uniandes.cupi2.simuladorBancario.interfaz;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.CompoundBorder;
import javax.swing.border.EmptyBorder;
import javax.swing.border.TitledBorder;

/**
 * Panel con las opciones de la aplicaci�n.
 */
@SuppressWarnings("serial")
public class PanelOpciones extends JPanel implements ActionListener
{

    // -----------------------------------------------------------------
    // Constantes
    // -----------------------------------------------------------------

    /**
     * Constante para la extensi�n 1.
     */
    private final static String OPCION_1 = "OPCION_1";

    /**
     * Constante para la extensi�n 2.
     */
    private final static String OPCION_2 = "OPCION_2";

    // -----------------------------------------------------------------
    // Atributos
    // -----------------------------------------------------------------

    /**
     * Ventana principal del simulador.
     */
    private InterfazSimulador principal;

    // -----------------------------------------------------------------
    // Atributos de Interfaz
    // -----------------------------------------------------------------

    /**
     * Bot�n para hacer la extensi�n 1.
     */
    private JButton opcion1;

    /**
     * Bot�n para hacer la extensi�n 2.
     */
    private JButton opcion2;

    // -----------------------------------------------------------------
    // Constructores
    // -----------------------------------------------------------------

    /**
     * Crea un nuevo panel e inicializa sus elementos. <br>
     * <b>post: </b> Se inicializ� el panel.
     * @param pPrincipal Ventana principal de la aplicaci�n. pPrincipal != null.
     */
    public PanelOpciones( InterfazSimulador pPrincipal )
    {

        // Inicializa los elementos del panel
        principal = pPrincipal;
        opcion1 = new JButton( );
        opcion1.setText( "Calcular Saldo Promedio" );
        opcion1.setActionCommand( OPCION_1 );
        opcion1.addActionListener( this );

        opcion2 = new JButton( );
        opcion2.setText( "Ver Resumen Transacciones" );
        opcion2.setActionCommand( OPCION_2 );
        opcion2.addActionListener( this );

        // Ubica los elementos en el panel
        setBorder( new CompoundBorder( new EmptyBorder( 0, 0, 5, 0 ), new TitledBorder( "Opciones" ) ) );
        setLayout( new GridLayout( 1, 2 ) );
        add( opcion1 );
        add( opcion2 );
    }

    // -----------------------------------------------------------------
    // Metodos
    // -----------------------------------------------------------------

    /**
     * Manejo de los eventos de los botones.
     * @param pEvento Evento de click sobre un bot�n. pEvento != null.
     */
    public void actionPerformed( ActionEvent pEvento )
    {
        try
        {
            String command = pEvento.getActionCommand( );
            if( command.equals( OPCION_1 ) )
            {
                String mesInicio = JOptionPane.showInputDialog(principal, 
                    "Introduzca el mes inicial del periodo:", 
                    "Calcular Saldo Promedio", 
                    JOptionPane.QUESTION_MESSAGE);
                
                String mesFin = JOptionPane.showInputDialog(principal, 
                    "Introduzca el mes final del periodo:", 
                    "Calcular Saldo Promedio", 
                    JOptionPane.QUESTION_MESSAGE);
                    
                if (mesInicio != null && mesFin != null) {
                    int inicio = Integer.parseInt(mesInicio);
                    int fin = Integer.parseInt(mesFin);
                    double promedio = principal.calcularSaldoPromedio(inicio, fin);
                    JOptionPane.showMessageDialog(principal, 
                        "El saldo promedio del período es: $" + String.format("%.2f", promedio),
                        "Resultado",
                        JOptionPane.INFORMATION_MESSAGE);
                }
            }
            else if( command.equals( OPCION_2 ) )
            {
                String resumen = principal.obtenerResumenTransacciones();
                JOptionPane.showMessageDialog(principal, 
                    resumen,
                    "Resumen de Transacciones",
                    JOptionPane.INFORMATION_MESSAGE);
            }
        }
        catch( Exception e )
        {
            JOptionPane.showMessageDialog( principal, "Información inválida: intente de nuevo..." );
        }
    

    }

}
