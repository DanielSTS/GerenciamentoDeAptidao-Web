package classes;

public class TesteBanco {

	public static void main(String[] args) {
		
		Professor	professor	=	new	Professor();
		
		professor.setNome("Caelum");
		professor.setEmail("professor@caelum.com.br");
		professor.setAreaDeFormacao("area");
		professor.setDataNascimento("13/08/1998");
		professor.setSenha("ojdhdd");
		professor.setSexo("masculino");
		professor.setTitulacao("mestre");
		professor.setMatricula(1256);
		
		//	grave	nessa	conexão!!!
		ProfessorDao dao	=	new	ProfessorDao();
		//	método	elegante
		dao.adiciona(professor);
		System.out.println("Gravado!");
	}

}
