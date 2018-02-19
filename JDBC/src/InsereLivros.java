import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.util.Scanner;

public class InsereLivros {

	public static void main(String[] args) {
		String stringDeConexao = "jdbc:mysql://localhost:3306/livraria";
		String usuario = "root";
		String senha = "root";

		Scanner entrada = new Scanner(System.in);

		try {
			System.out.println("Abrindo conexão...");
			Connection conexao = DriverManager.getConnection(stringDeConexao, usuario, senha);

			System.out.println("Digite o título do livro: ");
			String titulo = entrada.nextLine();

			System.out.println("Digite o preço: ");
			double preco = entrada.nextDouble();

			System.out.println("Digite o id da editora: ");
			int idEditora = entrada.nextInt();

			String sql = "INSERT INTO Livro (titulo, preco, editora_id) VALUES ('" + titulo + "','" + preco + "','"
					+ idEditora + "')";
			PreparedStatement comando = conexao.prepareStatement(sql);

			System.out.println("Executando comando...");
			comando.execute();

			System.out.println("Fechando conexão...");
			conexao.close();
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
