package poo.base.writingReading.createFolder;

public class Main {

	@SuppressWarnings("unused")
	public static void main(String[] args) {

		CreateDir dir = new CreateDir();
		// se o caminho nao existir o metodo cria todo
		String path1 = "/home/arcade/Workstation/JavaLearning/src/poo/base/writingReading/Out";
		// se o diretorio estiver vazio o metodo cria um diretorio
		String path2 = "/home/arcade/Workstation/JavaLearning/src/poo/base/writingReading/createFolder/";
		// se o diretorio ja abriga diretorios ele apenas imprime todos eles 
		String path3 = "/home/arcade/Workstation/JavaLearning/src/poo/base/writingReading";
		
		String path = path3;
		try {
			dir.isExitsDir(path);			
		} catch(NullPointerException e) {
			System.out.println(e.getMessage());
		}

		IO.println();

	}

}
