package com.app.sportsmobile.cartola.model;

/**
 * Created by Edson on 13/01/2017.
 */
public class Scout {

    public int CA;
    public int FC;
    public int FD;
    public int FF;
    public int FS;
    public int G;
    public int PE;
    public int RB;
    public int A;
    public int FT;
    public int I;
    public int PP;
    public int GC;
    public int CV;
    public int SG;
    public int DD;
    public int DP;
    public int GS;

    public Scout() {
    }

    public Scout(int CA,
                 int FC,
                 int FD,
                 int FF,
                 int FS,
                 int G,
                 int PE,
                 int RB,
                 int A,
                 int FT,
                 int I,
                 int PP,
                 int GC,
                 int CV,
                 int SG,
                 int DD,
                 int DP,
                 int GS

    )
    {
        this.CA = CA;
        this.FC = FC;
        this.FD = FD;
        this.FF = FF;
        this.FS = FS;
        this.G = G;
        this.PE = PE;
        this.RB = RB;
        this.A = A;
        this.FT = FT;
        this.I = I;
        this.GC = GC;
        this.CV = CV;
        this.SG = SG;
        this.DD = DD;
        this.DP = DP;
        this.GS = GS;

    }

    public int getCartaoAmarelo() {
        return CA;
    }

    public void setCartaoAmarelo(int CA) {
        this.CA = CA;
    }


    public int getFaltasCometidas() {
        return FC;
    }

    public void setFaltasCometidas(int FC) {
        this.FC = FC;
    }

    public int getFinalizacoesDefendidas() {
        return FD;
    }

    public void setFinalizacoesDefendidas(int FD) {
        this.FD = FD;
    }

    public int getFinalizacoesParaFora() {
        return FF;
    }

    public void setFinalizacoesParaFora(int FF) {
        this.FF = FF;
    }


    public int getFaltasSofridas() {
        return FS;
    }

    public void setFaltasSofridas(int FS) {
        this.FS = FS;
    }


    public int getGols() {
        return G;
    }

    public void setGols(int G) {
        this.G = G;
    }

    public int getPassesErrados() {
        return PE;
    }

    public void setPassesErrados(int PE) {
        this.PE = PE;
    }

    public int getRoubadaDeBola() {
        return RB;
    }

    public void setRoubadaDeBola(int RB) {
        this.RB = RB;
    }

    public int getAssistencia() {
        return A;
    }

    public void setAssistencia(int A) {
        this.A = A;
    }

    public int getFinalizacoesNaTrave() {
        return FT;
    }

    public void setFinalizacoesNaTrave(int FT) {
        this.FT = FT;
    }

    public int getImpedimento() {
        return I;
    }

    public void setImpedimento(int I) {
        this.I = I;
    }

    public int getPenaltiPerdido() {
        return PP;
    }

    public void setPenaltiPerdido(int PP) {
        this.PP = PP;
    }

    public int getGolContra() {
        return GC;
    }

    public void setGolContra(int GC) {
        this.GC = GC;
    }

    public int getCartaoVermelho() {
        return CV;
    }

    public void setCartaoVermelho(int CV) {
        this.CV = CV;
    }

    public int getSemSofrerGol() {
        return SG;
    }

    public void setSemSofrerGol(int SG) {
        this.SG = SG;
    }

    public int getDefesasDificeis() {
        return DD;
    }

    public void setDefesasDificeis(int DD) {
        this.DD = DD;
    }

    public int getDefesaDePenalti() {
        return DP;
    }

    public void setDefesaDePenalti(int DP) {
        this.DP = DP;
    }

    public int getGolSofrido() {
        return GS;
    }

    public void setGolSofrido(int GS) {
        this.GS = GS;
    }

}
