package org.example;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class TarefasDAO {

    private static Conexao conexao = new Conexao();

    //só para testar se esta conectado ou n:
    public TarefasDAO(){
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
    public static int inserir(Tarefas obj){
        conexao.conectar();
        String Sql = "insert into Tarefas(id,aula_id,descricao) values(?,?,?)";
        PreparedStatement stmt = conexao.prepareStatement(Sql);
        try{
            stmt.setInt(1, obj.getId());
            stmt.setInt(2, obj.getAula_id());
            stmt.setString(3, obj.getDescricao());
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
    public static int alterar(Tarefas obj){
        conexao.conectar();
        String Sql = "update Tarefas set aula_id = ?,descricao=? where id=?";
        PreparedStatement stmt = conexao.prepareStatement(Sql);
        try{
            stmt.setInt(1, obj.getId());
            stmt.setInt(2, obj.getAula_id());
            stmt.setString(3, obj.getDescricao());
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

    public int remover(Tarefas obj){
        conexao.conectar();
        String Sql = "delete from Tarefas where id=?";
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

    public Tarefas retorna(int Id){
        conexao.conectar();
        String Sql = "select id, aula_id ,descricao from Tarefas where id=?";
        PreparedStatement stmt = conexao.prepareStatement(Sql);
        try{
            stmt.setInt(1, Id);
            ResultSet retorno = stmt.executeQuery();

            if(retorno.next()){
                Tarefas obj = new Tarefas();
                obj.setId(retorno.getInt("id"));
                obj.setAula_id(retorno.getInt("aula_id"));
                obj.setDescricao(retorno.getString("descricao"));
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
