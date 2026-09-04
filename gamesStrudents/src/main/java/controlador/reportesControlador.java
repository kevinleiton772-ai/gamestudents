package controlador;

import java.awt.Desktop;
import java.io.File;
import java.io.FileOutputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import javax.swing.JFrame;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import modelo.Reporte;
import vista.reportesVista;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.data.category.DefaultCategoryDataset;

public class reportesControlador {

    private Reporte modelo;
    private reportesVista vista;
    private JFrame ventanaAnterior;
    private JFreeChart graficoActual;

    private ArrayList<Reporte> listaReporte =
            new ArrayList<>();

    public reportesControlador() {
    }

    public reportesControlador(
            Reporte modelo,
            reportesVista vista,
            JFrame ventanaAnterior) {

        this.modelo = modelo;
        this.vista = vista;
        this.ventanaAnterior = ventanaAnterior;
    }

    public void iniciar() {

        vista.getBtnPrevisualizar().addActionListener(
                e -> listarReporte()
        );

        vista.getBtnPDF().addActionListener(
                e -> generarPDF()
        );

        vista.getBtnGrafico().addActionListener(
                e -> mostrarGrafico()
        );

        vista.getBtnSalir().addActionListener(
                e -> salir()
        );

        cargarVideojuegos();
        cargarEstados();

        vista.setLocationRelativeTo(null);
        vista.setVisible(true);
    }

    public void cargarVideojuegos() {

        vista.getCmbVideojuego().removeAllItems();

        vista.getCmbVideojuego().addItem(
                "Todos los videojuegos"
        );

        vista.getCmbVideojuego().addItem("FIFA");
        vista.getCmbVideojuego().addItem("League of Legends");
        vista.getCmbVideojuego().addItem("Valorant");
        vista.getCmbVideojuego().addItem("Free Fire");
        vista.getCmbVideojuego().addItem("Call of Duty");
        vista.getCmbVideojuego().addItem("Fortnite");
        vista.getCmbVideojuego().addItem("Minecraft");
        vista.getCmbVideojuego().addItem("Counter Strike");
    }

    public void cargarEstados() {

        vista.getCmbEstado().removeAllItems();

        vista.getCmbEstado().addItem(
                "Todos los estados"
        );

        vista.getCmbEstado().addItem("PLANIFICADO");
        vista.getCmbEstado().addItem("EN CURSO");
        vista.getCmbEstado().addItem("FINALIZADO");
        vista.getCmbEstado().addItem("CANCELADO");
    }

    private String obtenerEstado() {

        Object seleccionado =
                vista.getCmbEstado().getSelectedItem();

        if (seleccionado == null) {
            return "";
        }

        String estado =
                seleccionado.toString();

        if (estado.equals("Todos los estados")) {
            return "";
        }

        return estado;
    }

    private String obtenerVideojuego() {

        Object seleccionado =
                vista.getCmbVideojuego()
                        .getSelectedItem();

        if (seleccionado == null) {
            return "";
        }

        String videojuego =
                seleccionado.toString();

        if (videojuego.equals(
                "Todos los videojuegos")) {

            return "";
        }

        return videojuego;
    }

    public void listarReporte() {

        String fechaInicio =
                vista.getTxtFechaInicio().trim();

        String fechaFin =
                vista.getTxtFechaFin().trim();

        String videojuego =
                obtenerVideojuego();

        String estado =
                obtenerEstado();

        if (fechaInicio.isEmpty()
                || fechaFin.isEmpty()) {

            JOptionPane.showMessageDialog(
                    vista,
                    "Ingrese la fecha de inicio y la fecha de fin.",
                    "Advertencia",
                    JOptionPane.WARNING_MESSAGE
            );

            return;
        }

        if (!validarFecha(fechaInicio)
                || !validarFecha(fechaFin)) {

            JOptionPane.showMessageDialog(
                    vista,
                    "Ingrese las fechas en formato AAAA-MM-DD.\n"
                    + "Ejemplo: 2026-09-01",
                    "Fecha incorrecta",
                    JOptionPane.WARNING_MESSAGE
            );

            return;
        }

        if (fechaInicio.compareTo(fechaFin) > 0) {

            JOptionPane.showMessageDialog(
                    vista,
                    "La fecha de inicio no puede ser mayor que la fecha de fin.",
                    "Error",
                    JOptionPane.ERROR_MESSAGE
            );

            return;
        }

        try {

            listaReporte =
                    Reporte.listarReporte(
                            fechaInicio,
                            fechaFin,
                            estado,
                            videojuego
                    );

            if (listaReporte == null) {
                listaReporte =
                        new ArrayList<>();
            }

            JTable tabla =
                    vista.getTablaReporte();

            DefaultTableModel modeloTabla =
                    new DefaultTableModel() {

                @Override
                public boolean isCellEditable(
                        int fila,
                        int columna) {

                    return false;
                }
            };

            modeloTabla.addColumn("ID");
            modeloTabla.addColumn("Nombre");
            modeloTabla.addColumn("Videojuego");
            modeloTabla.addColumn("Fecha Inicio");
            modeloTabla.addColumn("Fecha Fin");
            modeloTabla.addColumn("Premio");
            modeloTabla.addColumn("Rondas");
            modeloTabla.addColumn("Estado");
            modeloTabla.addColumn("Organizador");

            for (Reporte reporte :
                    listaReporte) {

                modeloTabla.addRow(
                        new Object[]{

                            reporte.getIdTorneo(),

                            reporte.getNombre(),

                            reporte.getVideojuego(),

                            reporte.getFechaInicio(),

                            reporte.getFechaFin(),

                            reporte.getPremioTotal(),

                            reporte.getNumRondas(),

                            reporte.getEstado(),

                            reporte.getIdOrganizador()
                        }
                );
            }

            tabla.setModel(modeloTabla);

            tabla.revalidate();
            tabla.repaint();

            if (listaReporte.isEmpty()) {

                JOptionPane.showMessageDialog(
                        vista,
                        "No hay torneos para el filtro seleccionado.",
                        "Reporte",
                        JOptionPane.INFORMATION_MESSAGE
                );

            } else {

                JOptionPane.showMessageDialog(
                        vista,
                        "Reporte generado correctamente.\n"
                        + "Total de torneos: "
                        + listaReporte.size(),
                        "Reporte",
                        JOptionPane.INFORMATION_MESSAGE
                );
            }

        } catch (Exception e) {

            e.printStackTrace();

            JOptionPane.showMessageDialog(
                    vista,
                    "Error al generar el reporte:\n\n"
                    + e.getMessage(),
                    "Error",
                    JOptionPane.ERROR_MESSAGE
            );
        }
    }

    private boolean validarFecha(String fecha) {

        if (fecha == null
                || fecha.length() != 10) {

            return false;
        }

        if (fecha.charAt(4) != '-'
                || fecha.charAt(7) != '-') {

            return false;
        }

        try {

            int anio =
                    Integer.parseInt(
                            fecha.substring(0, 4)
                    );

            int mes =
                    Integer.parseInt(
                            fecha.substring(5, 7)
                    );

            int dia =
                    Integer.parseInt(
                            fecha.substring(8, 10)
                    );

            if (anio < 2000
                    || anio > 2100) {

                return false;
            }

            if (mes < 1
                    || mes > 12) {

                return false;
            }

            if (dia < 1
                    || dia > 31) {

                return false;
            }

            return true;

        } catch (NumberFormatException e) {

            return false;
        }
    }

    public void generarPDF() {

        if (listaReporte == null
                || listaReporte.isEmpty()) {

            JOptionPane.showMessageDialog(
                    vista,
                    "Primero debe previsualizar el reporte.",
                    "Advertencia",
                    JOptionPane.WARNING_MESSAGE
            );

            return;
        }

        JFileChooser selector =
                new JFileChooser();

        selector.setDialogTitle(
                "Guardar reporte PDF"
        );

        selector.setSelectedFile(
                new File("Reporte_Torneos.pdf")
        );

        int opcion =
                selector.showSaveDialog(vista);

        if (opcion != JFileChooser.APPROVE_OPTION) {
            return;
        }

        String archivo =
                selector.getSelectedFile()
                        .getAbsolutePath();

        if (!archivo.toLowerCase()
                .endsWith(".pdf")) {

            archivo += ".pdf";
        }

        try {

            com.itextpdf.text.Document documento =
                    new com.itextpdf.text.Document();

            com.itextpdf.text.pdf.PdfWriter
                    .getInstance(
                            documento,
                            new FileOutputStream(
                                    archivo
                            )
                    );

            documento.open();

            com.itextpdf.text.Font titulo =
                    new com.itextpdf.text.Font(
                            com.itextpdf.text.Font.FontFamily.HELVETICA,
                            18,
                            com.itextpdf.text.Font.BOLD
                    );

            documento.add(
                    new com.itextpdf.text.Paragraph(
                            "REPORTE DE TORNEOS",
                            titulo
                    )
            );

            documento.add(
                    new com.itextpdf.text.Paragraph(
                            "Fecha inicio: "
                            + vista.getTxtFechaInicio()
                    )
            );

            documento.add(
                    new com.itextpdf.text.Paragraph(
                            "Fecha fin: "
                            + vista.getTxtFechaFin()
                    )
            );

            documento.add(
                    new com.itextpdf.text.Paragraph(
                            "Videojuego: "
                            + vista.getVideojuegoSeleccionado()
                    )
            );

            documento.add(
                    new com.itextpdf.text.Paragraph(
                            "Estado: "
                            + vista.getEstadoSeleccionado()
                    )
            );

            documento.add(
                    new com.itextpdf.text.Paragraph(
                            "Total: "
                            + listaReporte.size()
                    )
            );

            documento.add(
                    new com.itextpdf.text.Paragraph(" ")
            );

            com.itextpdf.text.pdf.PdfPTable tablaPDF =
                    new com.itextpdf.text.pdf.PdfPTable(9);

            tablaPDF.setWidthPercentage(100);

            String[] encabezados = {

                "ID",
                "Nombre",
                "Videojuego",
                "Inicio",
                "Fin",
                "Premio",
                "Rondas",
                "Estado",
                "Organizador"
            };

            for (String encabezado :
                    encabezados) {

                tablaPDF.addCell(
                        new com.itextpdf.text.Phrase(
                                encabezado
                        )
                );
            }

            for (Reporte reporte :
                    listaReporte) {

                tablaPDF.addCell(
                        String.valueOf(
                                reporte.getIdTorneo()
                        )
                );

                tablaPDF.addCell(
                        reporte.getNombre() == null
                        ? ""
                        : reporte.getNombre()
                );

                tablaPDF.addCell(
                        reporte.getVideojuego() == null
                        ? ""
                        : reporte.getVideojuego()
                );

                tablaPDF.addCell(
                        reporte.getFechaInicio() == null
                        ? ""
                        : reporte.getFechaInicio()
                );

                tablaPDF.addCell(
                        reporte.getFechaFin() == null
                        ? ""
                        : reporte.getFechaFin()
                );

                tablaPDF.addCell(
                        reporte.getPremioTotal() == null
                        ? ""
                        : reporte.getPremioTotal().toString()
                );

                tablaPDF.addCell(
                        String.valueOf(
                                reporte.getNumRondas()
                        )
                );

                tablaPDF.addCell(
                        reporte.getEstado() == null
                        ? ""
                        : reporte.getEstado()
                );

                tablaPDF.addCell(
                        String.valueOf(
                                reporte.getIdOrganizador()
                        )
                );
            }

            documento.add(tablaPDF);

            documento.close();

            JOptionPane.showMessageDialog(
                    vista,
                    "PDF generado correctamente.",
                    "PDF",
                    JOptionPane.INFORMATION_MESSAGE
            );

            try {

                if (Desktop.isDesktopSupported()) {

                    Desktop.getDesktop()
                            .open(
                                    new File(archivo)
                            );
                }

            } catch (Exception e) {

                System.out.println(
                        "No se pudo abrir el PDF automáticamente."
                );
            }

        } catch (Exception e) {

            e.printStackTrace();

            JOptionPane.showMessageDialog(
                    vista,
                    "Error al generar PDF:\n\n"
                    + e.getMessage(),
                    "Error",
                    JOptionPane.ERROR_MESSAGE
            );
        }
    }

    public void mostrarGrafico() {

        if (listaReporte == null
                || listaReporte.isEmpty()) {

            JOptionPane.showMessageDialog(
                    vista,
                    "Primero debe previsualizar un reporte con datos.",
                    "Advertencia",
                    JOptionPane.WARNING_MESSAGE
            );

            return;
        }

        try {

            Map<String, Integer> cantidades =
                    new HashMap<>();

            for (Reporte reporte :
                    listaReporte) {

                String videojuego =
                        reporte.getVideojuego();

                if (videojuego == null
                        || videojuego.trim().isEmpty()) {

                    videojuego =
                            "Sin videojuego";
                }

                videojuego =
                        videojuego.trim();

                cantidades.put(
                        videojuego,
                        cantidades.getOrDefault(
                                videojuego,
                                0
                        ) + 1
                );
            }

            DefaultCategoryDataset datos =
                    new DefaultCategoryDataset();

            for (Map.Entry<String, Integer> entrada :
                    cantidades.entrySet()) {

                datos.addValue(
                        entrada.getValue(),
                        "Torneos",
                        entrada.getKey()
                );
            }

            graficoActual =
                    ChartFactory.createBarChart(
                            "Torneos por videojuego",
                            "Videojuego",
                            "Cantidad",
                            datos
                    );

            ChartPanel panel =
                    new ChartPanel(
                            graficoActual
                    );

            JFrame ventanaGrafico =
                    new JFrame(
                            "Estadística de torneos"
                    );

            ventanaGrafico.setDefaultCloseOperation(
                    JFrame.DISPOSE_ON_CLOSE
            );

            ventanaGrafico.add(panel);

            ventanaGrafico.setSize(
                    800,
                    500
            );

            ventanaGrafico.setLocationRelativeTo(
                    vista
            );

            ventanaGrafico.setVisible(true);

        } catch (Exception e) {

            e.printStackTrace();

            JOptionPane.showMessageDialog(
                    vista,
                    "Error al generar gráfico:\n"
                    + e.getMessage(),
                    "Error",
                    JOptionPane.ERROR_MESSAGE
            );
        }
    }

    public void salir() {

        if (vista != null) {
            vista.dispose();
        }

        if (ventanaAnterior != null) {
            ventanaAnterior.setVisible(true);
        }
    }
}
