package bs;

import java.io.File;

import pojos.Client;

public class RemovePhotoBs {
	public static Boolean deletePhoto(Client client) {
		Boolean correct = false;
		File photo = new File(client.getPhoto());
		if(photo.delete()) {
			correct = true;
		}
		return correct;
	}
}
