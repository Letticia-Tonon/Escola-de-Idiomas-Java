package org.example;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class CursosDAO {

    private static Conexao conexao = new Conexao();

    //só para testar se esta conectado ou n:
    public CursosDAO(){
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
    public static int inserir(Cursos obj){
        conexao.conectar();
        String Sql = "insert into Notas(id,nome,descricao,preco) values(?,?,?,?)";
        PreparedStatement stmt = conexao.prepareStatement(Sql);
        try{
            stmt.setInt(1, obj.getId());
            stmt.setString(2, obj.getNome());
            stmt.setString(3, obj.getDescricao());
            stmt.setFloat(4, obj.getPreco());
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
    public static int alterar(Cursos obj){
        conexao.conectar();
        String Sql = "update Cursos set nome = ?,descricao=?, preco = ?, where id=?";
        PreparedStatement stmt = conexao.prepareStatement(Sql);
        try{
            stmt.setInt(1, obj.getId());
            stmt.setString(2, obj.getNome());
            stmt.setString(3, obj.getDescricao());
            stmt.setFloat(4, obj.getPreco());
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

    public int remover(Cursos obj){
        conexao.conectar();
        String Sql = "delete from Cursos where id=?";
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

    public Cursos retorna(int Id){
        conexao.conectar();
        String Sql = "select id, nome ,descricao, preco from Cursos where id=?";
        PreparedStatement stmt = conexao.prepareStatement(Sql);
        try{
            stmt.setInt(1, Id);
            ResultSet retorno = stmt.executeQuery();

            if(retorno.next()){
                Cursos obj = new Cursos();
                obj.setId(retorno.getInt("id"));
                obj.setNome(retorno.getString("nome"));
                obj.setDescricao(retorno.getString("descricao"));
                obj.setPreco(retorno.getFloat("preco"));
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
