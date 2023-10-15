/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package komputer;

import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author PF429
 */
public class DataKomputer implements AppInterface{
    private final Komputer[] komputer;
    private DefaultTableModel tableModel;
    private JTable dataTable;
    
    public DataKomputer(){
        komputer = new Komputer[1000];
        initializeTable();
    }
        private void initializeTable() {
        tableModel = new DefaultTableModel();
        tableModel.addColumn("Brand");
        tableModel.addColumn("Model");
        tableModel.addColumn("Disk Type");
        tableModel.addColumn("Disk Size (GB)");
        tableModel.addColumn("RAM Size (GB)");

        dataTable = new JTable(tableModel);
    }

    

    @Override
    public int pilihanMenu() {
            String p = JOptionPane.showInputDialog(null, ""
                    +"<html>"
                    +"=========Pilihan===================<br>"
                    +"1 &rarr; Tambah Data Komputer<br>" 
                    +"2 &rarr; Cari Berdasarkan Brand Komputer<br>" 
                    +"3 &rarr; Cari Berdasarkan Model Komputer<br>" 
                    +"4 &rarr; Keluar Aplikasi<br>" 
                    +"=====================================<br>"
                    +"<b>Ketik pilihan Anda:</b>"
                    +"</html>",
                    "Menu Pilihan",
                    JOptionPane.QUESTION_MESSAGE);
            int pilihan = Integer.parseInt(p);//casting
            return pilihan;
    }

    @Override
    public void add() {
       Komputer kom = new Komputer();
       String brand = JOptionPane.showInputDialog(null, "Ketik Brand:", ""
                + "Brand", JOptionPane.QUESTION_MESSAGE);
       kom.setBrand(brand);
       String model=JOptionPane.showInputDialog(null,"Ketik Model:",""
                +"Model", JOptionPane.QUESTION_MESSAGE);
       kom.setModel(model);
       String disk=JOptionPane.showInputDialog(null,"Tipe Disk (SSD/Hardisk):",""
                +"Tipe Disk", JOptionPane.QUESTION_MESSAGE);
       kom.setDiskType(disk);
       String size=JOptionPane.showInputDialog(null,"Kapasitas Disk(Angka):",""
                +"Kapasitas Disk (dalam GB)", JOptionPane.QUESTION_MESSAGE);
       int diskSize = Integer.parseInt(size);//casting
       kom.setDiskSize(diskSize);
       String ram=JOptionPane.showInputDialog(null,"Kapasitas RAM(Angka):",""
                +"Ukuran RAM (dalam GB)", JOptionPane.QUESTION_MESSAGE);
       int ramSize = Integer.parseInt(ram);//casting
       kom.setRam(ramSize);
       
       for (int i = 0; i < komputer.length; i++){
           if(komputer[i] == null){
               komputer[i] = kom;
               break;
           }
       }
       
       viewData(kom);
//       updateTable();
    }
//    private void updateTable() {
//        clearTable();
//        for (Komputer k : komputer) {
//            if (k != null) {
//                tableModel.addRow(new Object[]{
//                        k.getBrand(),
//                        k.getModel(),
//                        k.getDiskType(),
//                        k.getDiskSize(),
//                        k.getRam()
//                });
//            }
//        }
//    }

    @Override
    public String keyword(String type) {
        String key = JOptionPane.showInputDialog(null,
                "Ketik "+type+" Komputer",
                type, JOptionPane.QUESTION_MESSAGE);
        return key;
    }

    @Override
    public Komputer searchByBrand(String brand) {
        Komputer komp = null;
        for (Komputer k : komputer){
            if(k !=null && k.getBrand().toLowerCase().contains(brand.toLowerCase())){
                komp = k;
                break;
            }
        }
        return komp;
    }

    @Override
    public Komputer searchByModel(String model) {
        Komputer komp = null;
        for(Komputer k : komputer){
            if(k !=null && k.getModel().toLowerCase().contains(model.toLowerCase())){
                 komp = k;
                 break;
            }
        }
        return komp;
    }

    @Override
    public void viewData(Komputer k) {
        if(k == null){
            JOptionPane.showMessageDialog(null,"Data tidak dapat ditemukan!" );
        }else{
            JOptionPane.showMessageDialog(null,
                "Brand\t\t:"+k.getBrand()+
                "\nModel\t\t:"+k.getModel()+
                "\nDisk Type\t:"+k.getDiskType()+
                "\nDisk Size\t:"+k.getDiskSize()+
                "\nRAM Size\t:"+k.getRam(),
                "Data Komputer",   
                JOptionPane.INFORMATION_MESSAGE);
        }
    }

    @Override
    public void exit() {
        System.exit(0);

    }

//    private void clearTable() {
//        while (tableModel.getRowCount() > 0) {
//            tableModel.removeRow(0);
//        }
//    }
    
}
