package org.example;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class MatriculasDAO {

    private static Conexao conexao = new Conexao();

    //só para testar se esta conectado ou n:
    public MatriculasDAO(){
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
    public static int inserir(Matriculas obj){
        conexao.conectar();
        String Sql = "insert into Matriculas(id,aluno_id,curso_id,data_matricula) values(?,?,?,?)";
        PreparedStatement stmt = conexao.prepareStatement(Sql);
        try{
            stmt.setInt(1, obj.getId());
            stmt.setInt(2, obj.getAluno_id());
            stmt.setInt(3, obj.getCurso_id().getId());
            stmt.setDate(4, Date.valueOf(obj.getData_matricula()));
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
    public static int alterar(Matriculas obj){
        conexao.conectar();
        String Sql = "update Matriculas set aluno_id=?, curso_id=?, data_hora=? where id=?";
        PreparedStatement stmt = conexao.prepareStatement(Sql);
        try{
            stmt.setInt(1, obj.getId());
            stmt.setInt(2, obj.getAluno_id());
            stmt.setInt(3, obj.getCurso_id().getId());
            stmt.setDate(4, Date.valueOf(obj.getData_matricula()));
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

    public int remover(Matriculas obj){
        conexao.conectar();
        String Sql = "delete from Matriculas where id=?";
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

    public Matriculas retorna(int Id){
        conexao.conectar();
        String Sql = "select id, aluno_id ,curso_id, data_matricula from Matriculas where id=?";
        PreparedStatement stmt = conexao.prepareStatement(Sql);
        try{
            stmt.setInt(1, Id);
            ResultSet retorno = stmt.executeQuery();

            if(retorno.next()){
                Matriculas obj = new Matriculas();
                obj.setId(retorno.getInt("id"));
                obj.setAluno_id(retorno.getInt("aluno_id"));
                obj.setCurso_id(retorno.getInt("curso_id"));
                obj.setData_matricula(retorno.getDate("data_matricula").toLocalDate());
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
