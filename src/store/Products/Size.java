/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package store.Products;

/**
 *
 * @author Lenovo
 */


    
    /// there are only standard sizes available from XS to XL
 public enum Size
    {
        XS,
        S,
        M,
        L,
        XL;

    public static Size getXS() {
        return XS;
    }

    public static Size getS() {
        return S;
    }

    public static Size getM() {
        return M;
    }

    public static Size getL() {
        return L;
    }

    public static Size getXL() {
        return XL;
    }
}

   