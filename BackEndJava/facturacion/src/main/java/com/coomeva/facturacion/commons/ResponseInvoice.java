package com.coomeva.facturacion.commons;

import com.coomeva.facturacion.model.dto.InvoiceDTO;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ResponseInvoice {


    private InvoiceDTO responseInvoiceDTO;


}
