package GUI;

import java.awt.Font;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

/**
 *
 * @author alber
 */
public class PJuego extends javax.swing.JPanel {
    public boolean turno1 = true;
    private JPanel Panel3EnRaya;
    private JButton botonVolver;
    JButton casillas[][];
    VPal v;
    public PJuego(VPal v) {
        this.v = v;
        initComponents();
    }
    

    private void initComponents() {
        //********************************DECLARACION DE VARIABLES**********************************************
        Panel3EnRaya = new JPanel();
        casillas = new JButton[3][3];
        Panel3EnRaya = new javax.swing.JPanel();
        botonVolver = new javax.swing.JButton();
        //********************************DECLARACION DE VARIABLES**********************************************
        
        //***METEMOS LAYOUTS AL PANEL GENERAL Y AL PANEL DE LOS casillas*****************************************
        setLayout(new java.awt.GridLayout(2, 1, 0, 18));
        Panel3EnRaya.setLayout(new java.awt.GridLayout(3, 3));
        //hacemos todo el bucle de juego en la funcion generarTablero
        this.generarTablero();
        
        //añadimos el panel del juego a la parte de arriba del panel
        add(Panel3EnRaya);
        
        //luego montamos el boton de volver con su accion correspondiente y lo añadimos abajo
        botonVolver.setText("Volver");
        botonVolver.addActionListener((java.awt.event.ActionEvent evt) -> {
            botonVolverActionPerformed();
        });
        add(botonVolver);
    }
   
    private void botonVolverActionPerformed() {                                            
        //reiniciamos el juego aqui por si dejamos una partida a medio empezar que la proxima vez que abramos este limpio de nuevo
        reiniciarJuego();
        v.setContentPane(v.ppal);
        //IMPORTANTE EL REVALIDATE QUE SI NO NO SE CAMBIA EL PANEL ***************************************************
        v.revalidate();
    }
    
    /*la verdad es que esto es una guarreria, deberia haber hecho una clase juego (creo yo)
    y meter toda la logica de si es el ganador y todo eso ahi pero no se mezclarlo, la verdad*/
    //I FILAS J COLUMNAS*********************
    public void generarTablero(){   
        /*hacemos un tablero de 3x3 (aunque creo que teniendo el gridLayout da igual y los añadimos*/
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                casillas[i][j] = new JButton("");
                casillas[i][j].setFont(new Font("Arial",Font.BOLD, 40));
                Panel3EnRaya.add(casillas[i][j]);
                /*convertimos la i y la j a otras variables para que no se pierdan después a la hora de los eventos
                al tener primero el bucle que hace todo primero*/
                int fila = i, columna = j;
                casillas[fila][columna].addActionListener(e -> {
                    if(casillas[fila][columna].getText().equalsIgnoreCase("")){
                        //AQUI PODEMOS CAMBIAR LO QUE SALGA EN LOS BOTONES, CAMBIAMOS EL 1 Y EL 2***************************************************
                        if (this.turno1)
                            casillas[fila][columna].setText("1");
                        else
                            casillas[fila][columna].setText("2");
                    }
                    if(verificarGanador(fila, columna)){
                        if (turno1){
                           JOptionPane.showMessageDialog(null, "Ha ganado el jugador 1");
                           reiniciarJuego();
                        }
                        else{
                            JOptionPane.showMessageDialog(null, "Ha ganado el jugador 2");
                            reiniciarJuego();
                        }
                    }else if (esEmpate()){
                        JOptionPane.showMessageDialog(null, "EMPATEEEEEEEE");
                        reiniciarJuego();
                    }
                    turno1 = !turno1;
                });
                
            }
        }
    }

    private boolean verificarGanador(int fila, int columna) {
        if(filaIgual(fila) || columnaIgual(columna) || diago1Igual() || diago2Igual())
            return true;
        else
            return false;
    }
    //comprueba todas las casillas, si hay alguna vacia devuelve false, si no, como no ha habido ganador, declara empate
    private boolean esEmpate(){
        for (int i = 0; i < 3; i++)
            for (int j = 0; j < 3; j++)
                if (casillas[i][j].getText().equals("")) 
                    return false;
        return true;
    }
    
    //restablece todas las casillas
    private void reiniciarJuego() {
        for (int i = 0; i < 3; i++)
            for (int j = 0; j < 3; j++)
                casillas[i][j].setText("");
        turno1 = true;
    }
    /*mira primero si la casilla primera está vacia. después si la primera casilla y la segunda son iguales,
    y despues si la segunda y la tercera son iguales. De esta forma puedes comprobar si cualquiera de las 3 casillas esta vacia
    y luego si todas son las mismas*/    
    private boolean filaIgual(int fila) {
        if (!casillas[fila][0].getText().equals("") &&
        casillas[fila][0].getText().equals(casillas[fila][1].getText()) &&
        casillas[fila][1].getText().equals(casillas[fila][2].getText()))
            return true;
        else
            return false;
    }
    //lo mismo que antes pero en columnas
    private boolean columnaIgual(int columna) {
        if (!casillas[0][columna].getText().equals("") &&
        casillas[0][columna].getText().equals(casillas[1][columna].getText()) &&
        casillas[1][columna].getText().equals(casillas[2][columna].getText())) 
            return true;
        else
            return false;
    }
    // hace lo mismo, pero esta vez solo tiene que comprobar 3 posiciones por lo que no hay que pasarle ni fila ni columna
    private boolean diago1Igual() {
        if (!casillas[0][0].getText().equals("") &&
        casillas[0][0].getText().equals(casillas[1][1].getText()) &&
        casillas[1][1].getText().equals(casillas[2][2].getText())) 
            return true;
        else
            return false;
    }
//igual que antes con la diagonal inversa
    private boolean diago2Igual() {
        if (!casillas[0][2].getText().equals("") &&
        casillas[0][2].getText().equals(casillas[1][1].getText()) &&
        casillas[1][1].getText().equals(casillas[2][0].getText())) 
            return true;
        else
            return false;
    }
}

//*******************EL LIMBO DE LO QUE NO VALE

// </editor-fold> 
    /*
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        Panel3EnRaya = new javax.swing.JPanel();
        casilla1 = new javax.swing.JButton();
        casilla2 = new javax.swing.JButton();
        casilla3 = new javax.swing.JButton();
        casilla4 = new javax.swing.JButton();
        casilla5 = new javax.swing.JButton();
        casilla6 = new javax.swing.JButton();
        casilla7 = new javax.swing.JButton();
        casilla8 = new javax.swing.JButton();
        casilla9 = new javax.swing.JButton();
        botonVolver = new javax.swing.JButton();

        setLayout(new java.awt.GridLayout(2, 1, 0, 18));

        Panel3EnRaya.setLayout(new java.awt.GridLayout(3, 3));

        casilla1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                casilla1ActionPerformed(evt);
            }
        });
        Panel3EnRaya.add(casilla1);
        Panel3EnRaya.add(casilla2);
        Panel3EnRaya.add(casilla3);
        Panel3EnRaya.add(casilla4);
        Panel3EnRaya.add(casilla5);
        Panel3EnRaya.add(casilla6);
        Panel3EnRaya.add(casilla7);
        Panel3EnRaya.add(casilla8);
        Panel3EnRaya.add(casilla9);

        add(Panel3EnRaya);

        botonVolver.setText("Volver");
        botonVolver.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonVolverActionPerformed(evt);
            }
        });
        add(botonVolver);
    }// </editor-fold>//GEN-END:initComponents

    private void botonVolverActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonVolverActionPerformed
        v.setContentPane(v.ppal);
        //IMPORTANTE EL REVALIDATE QUE SI NO NO SE CAMBIA EL PANEL ***************************************************
        v.revalidate();
    }//GEN-LAST:event_botonVolverActionPerformed

    private void casilla1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_casilla1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_casilla1ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel Panel3EnRaya;
    private javax.swing.JButton botonVolver;
    private javax.swing.JButton casilla1;
    private javax.swing.JButton casilla2;
    private javax.swing.JButton casilla3;
    private javax.swing.JButton casilla4;
    private javax.swing.JButton casilla5;
    private javax.swing.JButton casilla6;
    private javax.swing.JButton casilla7;
    private javax.swing.JButton casilla8;
    private javax.swing.JButton casilla9;
    // End of variables declaration//GEN-END:variables
*/
 


