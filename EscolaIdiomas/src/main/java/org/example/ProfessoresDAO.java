package org.example;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ProfessoresDAO {

    private static Conexao conexao = new Conexao();

    //só para testar se esta conectado ou n:
    public ProfessoresDAO(){
        try{
            if(this.conexao.conectar()){
                System.out.println("Banco de dados conectado !!");
            }
        }
        catch(Exception err){
            System.err.println(err.getMessage());
        }
        finally{
            conexao.descontecar();
        }
    }
    //insere:
    public static int inserir(Usuario obj){
        conexao.conectar();
        String Sql = "insert into Professores(id,nome,email,senha) values(?,?,?,?)";
        PreparedStatement stmt = conexao.prepareStatement(Sql);
        try{
            stmt.setInt(1, obj.getId());
            stmt.setString(2, obj.getNome());
            stmt.setString(3, obj.getEmail());
            stmt.setString(4, obj.getSenha());
            return stmt.executeUpdate();
        }
        catch(SQLException err){
            System.err.println(err.getMessage());
            return 0;
        }
        finally{
            conexao.descontecar();
        }
    }
    public int alterar(Usuario obj) {
        conexao.conectar();
        String sql = "UPDATE Professores SET nome=?, email=?, senha=? WHERE id=?";
        try {
            PreparedStatement stmt = conexao.prepareStatement(sql);
            stmt.setInt(1, obj.getId());
            stmt.setString(2, obj.getNome());
            stmt.setString(3, obj.getEmail());
            stmt.setString(4, obj.getSenha());
            return stmt.executeUpdate();
        } catch (SQLException err) {
            System.err.println(err.getMessage());
            return 0;
        } finally {
            conexao.descontecar();
        }
    }


    public int remover(Usuario obj){
        conexao.conectar();
        String Sql = "delete from Professores where id=?";
        PreparedStatement stmt = conexao.prepareStatement(Sql);
        try{
            stmt.setLong(1, obj.getId());
            return stmt.executeUpdate();
        }
        catch(SQLException err){
            System.err.println(err.getMessage());
            return 0;
        }
        finally{
            conexao.descontecar();
        }
    }

    public Usuario retorna(int id){
        conexao.conectar();
        String Sql = "select id, nome, email, senha from Professores where id=?";
        PreparedStatement stmt = conexao.prepareStatement(Sql);
        try{
            stmt.setInt(1, id);
            ResultSet retorno = stmt.executeQuery();

            if(retorno.next()){
                Professores obj = new Professores();
                obj.setId(retorno.getInt("id"));
                obj.setNome(retorno.getString("nome"));
                obj.setEmail(retorno.getString("email"));
                obj.setSenha(retorno.getString("senha"));
                return obj;
            } else {
                return null;
            }
        }
        catch(SQLException err){
            System.err.println(err.getMessage());
            return null;
        }
        finally{
            conexao.descontecar();
        }
    }

}
