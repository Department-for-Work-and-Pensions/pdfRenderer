package service

import play.api.mvc.{Request, AnyContent, Results}
import generators.{GenerationFailure, GenerationSuccess, ReportGenerator}
import pdfService.Implicits._
import play.api.Logger
import java.io.OutputStream

/**
 * TODO write description
 * @author Jorge Migueis
 */
trait PdfService {

  protected def reportGenerator: ReportGenerator

  protected def outputStream: OutputStream

  def pdfGeneration(request: Request[AnyContent]) = {


    request.body.asXml.map {
      xml =>
        val generator = reportGenerator
        val print = generator.generateFrom(xml)

        generator.exportReportToStream(print, outputStream) match {
          case GenerationSuccess() =>
            Results.Ok

          case GenerationFailure() =>
            Results.InternalServerError

          case _ =>
            Logger.error("Unexpected result")
            Results.InternalServerError

        }

    }.getOrElse(Results.BadRequest)

  }

}