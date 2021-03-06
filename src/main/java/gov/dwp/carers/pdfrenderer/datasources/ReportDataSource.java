package gov.dwp.carers.pdfrenderer.datasources;

import net.sf.jasperreports.engine.JRDataSource;

/**
 * Created by peterwhitehead on 04/05/2016.
 */
public interface ReportDataSource {
    JRDataSource convertToJRDataSource();

    String getTransactionId();

    String getReportName();

    String getReportVersion();
}
