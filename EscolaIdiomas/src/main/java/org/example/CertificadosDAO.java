package org.example;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class CertificadosDAO {

    private static Conexao conexao = new Conexao();

    //só para testar se esta conectado ou n:
    public CertificadosDAO(){
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
    public static int inserir(Certificados obj){
        conexao.conectar();
        String Sql = "insert into Certificados(id,aluno_id,curso_id,data_conclusao) values(?,?,?,?)";
        PreparedStatement stmt = conexao.prepareStatement(Sql);
        try{
            stmt.setInt(1, obj.getId());
            stmt.setInt(2, obj.getAluno_id());
            stmt.setInt(3, obj.getCursos_id());
            stmt.setDate(4, Date.valueOf(obj.getData_conclusao()));
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
    public static int alterar(Certificados obj){
        conexao.conectar();
        String Sql = "update Certificados set aluno_id = ?,curso_id=?, data_conclusao = ?, where id=?";
        PreparedStatement stmt = conexao.prepareStatement(Sql);
        try{
            stmt.setInt(1, obj.getId());
            stmt.setInt(2, obj.getAluno_id());
            stmt.setInt(3, obj.getCursos_id());
            stmt.setDate(4, Date.valueOf(obj.getData_conclusao()));
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

    public int remover(Certificados obj){
        conexao.conectar();
        String Sql = "delete from Certificados where id=?";
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

    public Certificados retorna(int Id){
        conexao.conectar();
        String Sql = "select id, aluno_id ,curso_id, data_conclusao from Certificados where id=?";
        PreparedStatement stmt = conexao.prepareStatement(Sql);
        try{
            stmt.setInt(1, Id);
            ResultSet retorno = stmt.executeQuery();

            if(retorno.next()){
                Certificados obj = new Certificados();
                obj.setId(retorno.getInt("id"));
                obj.setAluno_id(retorno.getInt("curso_id"));
                obj.setCursos_id(retorno.getInt("curso_id"));
                obj.setData_conclusao(retorno.getDate("data_conclusao").toLocalDate());
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
