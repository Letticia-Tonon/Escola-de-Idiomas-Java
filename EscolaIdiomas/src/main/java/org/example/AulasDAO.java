package org.example;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class AulasDAO {

    private static Conexao conexao = new Conexao();

    //só para testar se esta conectado ou n:
    public AulasDAO(){
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
    public static int inserir(Aulas obj){
        conexao.conectar();
        String Sql = "insert into Aulas(id,curso_id,professor_id,data_hora, conteudo) values(?,?,?,?,?)";
        PreparedStatement stmt = conexao.prepareStatement(Sql);
        try{
            stmt.setInt(1, obj.getId());
            stmt.setInt(2, obj.getCurso_id());
            stmt.setInt(3, obj.getProfessor_id());
            stmt.setDate(4, Date.valueOf(obj.getData_hora()));
            stmt.setString(5, obj.getConteudo());
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
    public static int alterar(Aulas obj){
        conexao.conectar();
        String Sql = "update Aulas set curso_id=?, professor_id=?, data_hora=?, conteudo=? where id=?";
        PreparedStatement stmt = conexao.prepareStatement(Sql);
        try{
            stmt.setInt(1, obj.getId());
            stmt.setInt(2, obj.getCurso_id());
            stmt.setInt(3, obj.getProfessor_id());
            stmt.setDate(4, Date.valueOf(obj.getData_hora()));
            stmt.setString(5, obj.getConteudo());
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

    public int remover(Aulas obj){
        conexao.conectar();
        String Sql = "delete from Aulas where id=?";
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

    public Aulas retorna(int Id){
        conexao.conectar();
        String Sql = "select id, curso_id, professor_id, data_hora, conteudo from Aulas where id=?";
        PreparedStatement stmt = conexao.prepareStatement(Sql);
        try{
            stmt.setInt(1, Id);
            ResultSet retorno = stmt.executeQuery();

            if(retorno.next()){
                Aulas obj = new Aulas();
                obj.setId(retorno.getInt("id"));
                obj.setCurso_id(retorno.getInt("curso_id"));
                obj.setProfessor_id(retorno.getInt("curso_id"));
                obj.setData_hora(retorno.getDate("data_hora").toLocalDate());
                obj.setConteudo(retorno.getString("conteudo"));
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
