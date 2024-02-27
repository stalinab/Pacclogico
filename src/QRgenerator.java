import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import com.google.zxing.BarcodeFormat;
import com.google.zxing.EncodeHintType;
import com.google.zxing.WriterException;
import com.google.zxing.client.j2se.MatrixToImageWriter;
import com.google.zxing.common.BitMatrix;
import com.google.zxing.qrcode.QRCodeWriter;

public class QRgenerator {
/**
 * La siguiente funcion se encarga solo de obtener el QR,atraves de una url y depositarlo en la direccion correspondiente
 * @param URL, el URL para generar el QR
 * @param Path, la ruta donde se creo o modifica el nuevo QR
 */
    public void generarQR(String URL,String Path) {
        int anchura = 300; // Ancho del código QR
        int altura = 300; // Alto del código QR

        Map<EncodeHintType, Object> p = new HashMap<>();
        p.put(EncodeHintType.CHARACTER_SET, "UTF-8");

        try {
            QRCodeWriter qrCodeWriter = new QRCodeWriter();
            BitMatrix bitMatrix = qrCodeWriter.encode(URL, BarcodeFormat.QR_CODE, anchura, altura, p);
            File qrCodeFile = new File(Path);
            MatrixToImageWriter.writeToPath(bitMatrix, "png", qrCodeFile.toPath());

            System.out.println("Código QR generado con éxito en: " + Path);
        } catch (WriterException | IOException e) {
            System.err.println("Error al generar el código QR: " + e.getMessage());
        }
    }
}
