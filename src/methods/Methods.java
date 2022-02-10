package methods;

import java.io.ByteArrayOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;

public class Methods {

public void DescargarImagen(String imagenurl,String nombre ) {
			try {
			URL url  = new URL(imagenurl);
			URLConnection urlcon;
			try {
				urlcon = url.openConnection();
				
				InputStream is = urlcon.getInputStream();
				
				ByteArrayOutputStream out = new ByteArrayOutputStream();
				
				byte[] buf = new byte[1024];
				int n = 0;
				while (-1!=(n=is.read(buf)))
				{
				   out.write(buf, 0, n);
				}
				
				out.close();
				is.close();
				byte[] response = out.toByteArray();
				
				

				
				FileOutputStream fos = new FileOutputStream(nombre +".jpg");
				fos.write(response);
				fos.close();
			} catch (IOException e) {

				e.printStackTrace();
			}

		} catch (MalformedURLException e) {

			e.printStackTrace();
		}
}
		


}
