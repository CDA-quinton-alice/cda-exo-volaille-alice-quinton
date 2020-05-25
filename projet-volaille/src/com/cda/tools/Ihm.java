package com.cda.tools;

import java.io.InputStream;
import java.util.Scanner;

public class Ihm {
	public static final Ihm IHM_INS = new Ihm();
	
	private Scanner scanner;
	private boolean interactif;
	private boolean afficherCommentaire;
	
	private Ihm() {
		this.interactif = Boolean.TRUE;
		this.scanner = new Scanner(System.in);
	}
	
	public void changerMode(boolean pInteractif) {
		changerMode(pInteractif, false);
	}
	
	public void changerMode(boolean pInteractif, boolean pAfficherCommentaire) {
		if(this.interactif ^ pInteractif) {
			this.scanner.close();
			this.afficherCommentaire = pAfficherCommentaire;
			if(this.interactif) {
				InputStream vFileTestIs = this.getClass().getResourceAsStream("scenario.txt");
				this.scanner = new Scanner(vFileTestIs);
			} else {
				this.scanner = new Scanner(System.in);
			}
			this.interactif = pInteractif;
		}
	}
	
	public int lireEntier() {
		System.out.print("< ");
		int saisie = this.scanner.nextInt();
		if(!interactif) {
			System.out.print(saisie);
		}
		if(this.scanner.hasNextLine()) {
			String vComm = this.scanner.nextLine();
			if(this.afficherCommentaire) {
				System.out.print(vComm);
			}
		}
		System.out.println();
		return saisie;
	}
	
	public float lireFloat() {
		System.out.print("< ");
		float saisie = this.scanner.nextFloat();
		if(!interactif) {
			System.out.print(saisie);
		}
		if(this.scanner.hasNextLine()) {
			String vComm = this.scanner.nextLine();
			if(this.afficherCommentaire) {
				System.out.print(vComm);
			}
		}
		System.out.println();
		return saisie;
	}
	
	public String lireMot() {
		System.out.print("< ");
		String saisie = this.scanner.next();
		if(!interactif) {
			System.out.print(saisie);
		}
		if(this.scanner.hasNextLine()) {
			String vComm = this.scanner.nextLine();
			if(this.afficherCommentaire) {
				System.out.print(vComm);
			}
		}
		System.out.println();
		return saisie;
	}
	
	public String lireLigne() {
		System.out.print("< ");
		String saisie = this.scanner.nextLine();
		if(!interactif) {
			System.out.println(saisie);
		}
		return saisie;
	}
	
	public void afficher(String pMessage) {
		afficher(pMessage, true);
	}
	
	public void afficher(String pMessage, boolean pAvecSautDeLigne) {
		System.out.print(pMessage+(pAvecSautDeLigne?"\n":""));
	}
	
}
