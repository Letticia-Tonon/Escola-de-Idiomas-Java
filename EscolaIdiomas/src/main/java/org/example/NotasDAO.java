package org.example;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class NotasDAO {

    private static Conexao conexao = new Conexao();

    //só para testar se esta conectado ou n:
    public NotasDAO(){
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
    public static int inserir(Notas obj){
        conexao.conectar();
        String Sql = "insert into Notas(id,aluno_id,curso_id,nota) values(?,?,?,?)";
        PreparedStatement stmt = conexao.prepareStatement(Sql);
        try{
            stmt.setInt(1, obj.getId());
            stmt.setInt(2, obj.getAluno_id());
            stmt.setInt(3, obj.getCurso_id());
            stmt.setFloat(4, obj.getNota());
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
    public static int alterar(Notas obj){
        conexao.conectar();
        String Sql = "update Notas set nome = ?,aluno_id=?, curso_id= ?, nota=? where id=?";
        PreparedStatement stmt = conexao.prepareStatement(Sql);
        try{
            stmt.setInt(1, obj.getId());
            stmt.setInt(2, obj.getAluno_id());
            stmt.setInt(3, obj.getCurso_id());
            stmt.setFloat(4, obj.getNota());
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
        String Sql = "delete from Notas where id=?";
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

    public Notas retorna(int Id){
        conexao.conectar();
        String Sql = "select id, aluno_id ,curso_id, nota from Notas where id=?";
        PreparedStatement stmt = conexao.prepareStatement(Sql);
        try{
            stmt.setInt(1, Id);
            ResultSet retorno = stmt.executeQuery();

            if(retorno.next()){
                Notas obj = new Notas();
                obj.setId(retorno.getInt("id"));
                obj.setAluno_id(retorno.getInt("aluno_id"));
                obj.setCurso_id(retorno.getInt("curso_id"));
                obj.setNota(retorno.getFloat("nota"));
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
