package com.ogl.service;

import com.ogl.exception.NoSquareException;
import com.ogl.model.Matrix;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class MatrixMathematicsTest {

    Matrix matrix;
    double dataT[][] = {
            {11 ,12,13} ,
            {21,22,23} ,
            {31,32,33}
    } ;
    double dataI[][] = {
            {1 ,0,0} ,
            {0,2,2} ,
            {0,0,3}
    } ;
    double dataD[][] = {
            {1 ,0,0} ,
            {0,2,0} ,
            {0,0,3}
    } ;


    public MatrixMathematicsTest() {

        matrix = new Matrix(3,3) ;


        matrix.setValues(dataT);

    }



    @Test
    public void transpose() {
        matrix.setValues(dataT);
        Matrix tMatrix = MatrixMathematics.transpose(matrix) ;
        tMatrix = MatrixMathematics.transpose(tMatrix) ;

        for (int i = 0; i < matrix.getNrows(); i++) {
            assertArrayEquals(matrix.getValues()[i],tMatrix.getValues()[i] ,0);
        }


    }

    @Test
    public void inverse() throws Exception{
        matrix.setValues(dataI);
        Matrix tMatrix = MatrixMathematics.inverse(matrix) ;
        tMatrix = MatrixMathematics.inverse(tMatrix) ;

        for (int i = 0; i < matrix.getNrows(); i++) {
            assertArrayEquals(matrix.getValues()[i],tMatrix.getValues()[i] ,0);
        }
    }


    @Test
    public void determinant() throws Exception {
        matrix.setValues(dataT);

        Matrix matrix1Elem = new Matrix(new double[][]{{1}}) ;

        double determinant = MatrixMathematics.determinant(matrix1Elem) ;
        assertEquals(determinant , 1,0);


        determinant = MatrixMathematics.determinant(matrix) ;
        assertEquals(determinant , 0d ,0);
    }

    @Test
    public void cofactor() throws Exception{
        double dataC[][] = {
                {-10   ,20,-10} ,
                {20,-40,20} ,
                {-10,20,-10}
        } ;

        Matrix coMatrix = new Matrix(dataC) ;
        Matrix cMatrix = MatrixMathematics.cofactor(matrix) ;

        for (int i = 0; i < coMatrix.getNrows(); i++) {
            assertArrayEquals(coMatrix.getValues()[i],cMatrix.getValues()[i] ,0);
        }


    }

    @Test
    public void createSubMatrix() {
        matrix.setValues(dataT);
        double dataSub[][] = {
                {11,12} ,
                {21,22}
        } ;
        Matrix subMatrix = MatrixMathematics.createSubMatrix(matrix,2,2) ;
        for (int i = 0; i < subMatrix.getNrows(); i++) {
            assertArrayEquals(subMatrix.getValues()[i],dataSub[i] ,0);
        }

    }
    @Test(expected = NoSquareException.class)
    public void testException() throws NoSquareException{
        double dataSquare[][] = {
                {11,12}
        } ;
        Matrix mm = new Matrix(dataSquare);
        double determinant = MatrixMathematics.determinant(mm) ;
        assertEquals(determinant , 0d ,0);
    }

}