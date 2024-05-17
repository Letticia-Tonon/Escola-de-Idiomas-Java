package org.example;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class PagamentosDAO {

    private static Conexao conexao = new Conexao();

    //só para testar se esta conectado ou n:
    public PagamentosDAO(){
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
    public static int inserir(Pagamentos obj){
        conexao.conectar();
        String Sql = "insert into Pagamentos(id,aluno_id,curso_id,valor) values(?,?,?,?)";
        PreparedStatement stmt = conexao.prepareStatement(Sql);
        try{
            stmt.setInt(1, obj.getId());
            stmt.setInt(2, obj.getAluno_id());
            stmt.setInt(3, obj.getCurso_id());
            stmt.setFloat(4, obj.getValor());
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
    public static int alterar(Pagamentos obj){
        conexao.conectar();
        String Sql = "update Pagamentos set aluno_id=?, curso_id= ?, valor=? where id=?";
        PreparedStatement stmt = conexao.prepareStatement(Sql);
        try{
            stmt.setInt(1, obj.getId());
            stmt.setInt(2, obj.getAluno_id());
            stmt.setInt(3, obj.getCurso_id());
            stmt.setFloat(4, obj.getValor());
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

    public int remover(Pagamentos obj){
        conexao.conectar();
        String Sql = "delete from Pagamentos where id=?";
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

    public Pagamentos retorna(int Id){
        conexao.conectar();
        String Sql = "select id, aluno_id ,curso_id, valor from Pagamentos where id=?";
        PreparedStatement stmt = conexao.prepareStatement(Sql);
        try{
            stmt.setInt(1, Id);
            ResultSet retorno = stmt.executeQuery();

            if(retorno.next()){
                Pagamentos obj = new Pagamentos();
                obj.setId(retorno.getInt("id"));
                obj.setAluno_id(retorno.getInt("aluno_id"));
                obj.setCurso_id(retorno.getInt("curso_id"));
                obj.setValor(retorno.getFloat("valor"));
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
