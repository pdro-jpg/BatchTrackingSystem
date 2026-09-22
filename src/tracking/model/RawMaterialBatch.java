//Insumo Lote
package tracking.model;

import java.time.LocalDate;

//definicao das variaveis a serem utilizadas
public class RawMaterialBatch {
    private String inboundBatchId, batchName, supplier, supplierBatchCode;
    private LocalDate batchExpiration;
    private double availableQty;

    //construtor
    public RawMaterialBatch(String inboundBatchId, String batchName, String supplier, String supplierBatchCode, LocalDate batchExpiration, double availableQty) {
        this.inboundBatchId = inboundBatchId;
        this.batchName = batchName;
        this.supplier = supplier;
        this.supplierBatchCode = supplierBatchCode;
        this.batchExpiration = batchExpiration;
        this.availableQty = availableQty;
    }

   //funcao para verificar se esta vencido ou não
    public boolean isExpired() {
        return LocalDate.now().isAfter(this.batchExpiration);
    }

    //dar baixa na quantidade disponivel
    public void consumeQuantity(double qty) {
        if (qty > this.availableQty) {
            throw new IllegalArgumentException("Quantidade Insufficiente no lote " + inboundBatchId);
            //Se nao houver quantidade suficiente, lanca um erro para que o estoque nao fique negativo
        }
        this.availableQty -= qty;
    }

    //getters
    public String getInboundBatchId() {return inboundBatchId;}
    public String getBatchName() {return batchName;}
    public String getSupplier() {return supplier;}
    public String getSupplierBatchCode() {return supplierBatchCode;}
    public LocalDate getBatchExpiration() {return batchExpiration;}
    public double getAvailableQty() {return availableQty;}

}
