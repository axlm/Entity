package tech.anaxka.common.entity;


import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;
import javax.xml.bind.annotation.XmlType;

import static tech.anaxka.common.utility.lang.ToString.toStringBuilder;


@XmlType(name = "Nationalities")
@XmlEnum
public enum NationalityType {

    @XmlEnumValue("Afghanistan")
    AFGHANISTAN("Afghanistan", "Kabul", "af", "+93", "Afghanistan Afghani", "AFA"),
    @XmlEnumValue("Albania")
    ALBANIA("Albania", "Tiran", "al", "+355", "Albanian Lek", "ALL"),
    @XmlEnumValue("Algeria")
    ALGERIA("Algeria", "Algiers", "dz", "+213", "Algerian Dinar", "DZD"),
    @XmlEnumValue("American Samoa")
    AMERICAN_SAMOA("American Samoa", "Pago Pago", "as", "+684", "US Dollar", "USD"),
    @XmlEnumValue("Andorra")
    ANDORRA("Andorra", "Andorra", "ad", "+376", "Euro", "EUR"),
    @XmlEnumValue("Angola")
    ANGOLA("Angola", "Luanda", "ao", "+244", "Angolan New Kwanza", "AON"),
    @XmlEnumValue("Anguilla")
    ANGUILLA("Anguilla", "The Valley", "ai", "+1264", "East Caribbean Dollar", "XCD"),
    @XmlEnumValue("Antarctica")
    ANTARCTICA("Antarctica", "None", "aq", "+672", "East Caribbean Dollar", "XCD"),
    @XmlEnumValue("Antigua And Barbuda")
    ANTIGUA_AND_BARBUDA("Antigua and Barbuda", "St. Johns", "ag", "+1268", "East Caribbean Dollar", "XCD"),
    @XmlEnumValue("Argentina")
    ARGENTINA("Argentina", "Buenos Aires", "ar", "+54", "Argentine Peso", "ARS"),
    @XmlEnumValue("Armenia")
    ARMENIA("Armenia", "Yerevan", "am", "+374", "Armenian Dram", "AMD"),
    @XmlEnumValue("Aruba")
    ARUBA("Aruba", "Oranjestad", "aw", "+297", "Aruban Guilder", "AWG"),
    @XmlEnumValue("Australia")
    AUSTRALIA("Australia", "Canberra", "au", "+61", "Australian Dollar", "AUD"),
    @XmlEnumValue("Austria")
    AUSTRIA("Austria", "Vienna", "at", "+43", "Euro", "EUR"),
    @XmlEnumValue("Azerbaijan")
    AZERBAIJAN("Azerbaijan", "Baku", "az", "+994", "Azerbaijanian Manat", "AZM"),
    @XmlEnumValue("Bahamas")
    BAHAMAS("Bahamas", "Nassau", "bs", "+1242", "Bahamian Dollar", "BSD"),
    @XmlEnumValue("Bahrain")
    BAHRAIN("Bahrain", "Al-Manamah", "bh", "+973", "Bahraini Dinar", "BHD"),
    @XmlEnumValue("Bangladesh")
    BANGLADESH("Bangladesh", "Dhaka", "bd", "+880", "Bangladeshi Taka", "BDT"),
    @XmlEnumValue("Barbados")
    BARBADOS("Barbados", "Bridgetown", "bb", "+1246", "Barbados Dollar", "BBD"),
    @XmlEnumValue("Belarus")
    BELARUS("Belarus", "Minsk", "by", "+375", "Belarussian Ruble", "BYB"),
    @XmlEnumValue("Belgium")
    BELGIUM("Belgium", "Brussels", "be", "+32", "Euro", "EUR"),
    @XmlEnumValue("Belize")
    BELIZE("Belize", "Belmopan", "bz", "+501", "Belize Dollar", "BZD"),
    @XmlEnumValue("Benin")
    BENIN("Benin", "Porto-Novo", "bj", "+229", "CFA Franc BCEAO", "XOF"),
    @XmlEnumValue("Bermuda")
    BERMUDA("Bermuda", "Hamilton", "bm", "+1441", "Bermudian Dollar", "BMD"),
    @XmlEnumValue("Bhutan")
    BHUTAN("Bhutan", "Thimphu", "bt", "+975", "Bhutan Ngultrum", "BTN"),
    @XmlEnumValue("Bolivia")
    BOLIVIA("Bolivia", "La Paz", "bo", "+591", "Boliviano", "BOB"),
    @XmlEnumValue("Bosnia Herzegovina")
    BOSNIA_HERZEGOVINA("Bosnia-Herzegovina", "Sarajevo", "ba", "+387", "Marka", "BAM"),
    @XmlEnumValue("Botswana")
    BOTSWANA("Botswana", "Gaborone", "bw", "+267", "Botswana Pula", "BWP"),
    @XmlEnumValue("Brazil")
    BRAZIL("Brazil", "Brasilia", "br", "+55", "Brazilian Real", "BRL"),
    @XmlEnumValue("Brunei Darussalam")
    BRUNEI_DARUSSALAM("Brunei Darussalam", "Bandar Seri Begawan", "bn", "+673", "Brunei Dollar", "BND"),
    @XmlEnumValue("Bulgaria")
    BULGARIA("Bulgaria", "Sofia", "bg", "+359", "Bulgarian Lev", "BGL"),
    @XmlEnumValue("Burkina Faso")
    BURKINA_FASO("Burkina Faso", "Ouagadougou", "bf", "+226", "CFA Franc BCEAO", "XOF"),
    @XmlEnumValue("Burundi")
    BURUNDI("Burundi", "Bujumbura", "bi", "+257", "Burundi Franc", "BIF"),
    @XmlEnumValue("Cambodia")
    CAMBODIA("Cambodia", "Phnom Penh", "kh", "+855", "Kampuchean Riel", "KHR"),
    @XmlEnumValue("Cameroon")
    CAMEROON("Cameroon", "Yaounde", "cm", "+237", "CFA Franc BEAC", "XAF"),
    @XmlEnumValue("Canada")
    CANADA("Canada", "Ottawa", "ca", "+1", "Canadian Dollar", "CAD"),
    @XmlEnumValue("Cape Verde")
    CAPE_VERDE("Cape Verde", "Praia", "cv", "+238", "Cape Verde Escudo", "CVE"),
    @XmlEnumValue("Cayman Islands")
    CAYMAN_ISLANDS("Cayman Islands", "Georgetown", "ky", "+1345", "Cayman Islands Dollar", "KYD"),
    @XmlEnumValue("Central African Republic")
    CENTRAL_AFRICAN_REPUBLIC("Central African Republic", "Bangui", "cf", "+236", "CFA Franc BEAC", "XAF"),
    @XmlEnumValue("Chad")
    CHAD("Chad", "N'Djamena", "td", "+235", "CFA Franc BEAC", "XAF"),
    @XmlEnumValue("Chile")
    CHILE("Chile", "Santiago", "cl", "+56", "Chilean Peso", "CLP"),
    @XmlEnumValue("China")
    CHINA("China", "Beijing", "cn", "+86", "Yuan Renminbi", "CNY"),
    @XmlEnumValue("Christmas Island")
    CHRISTMAS_ISLAND("Christmas Island", "The Settlement", "cx", "+61", "Australian Dollar", "AUD"),
    @XmlEnumValue("Cocos Islands")
    COCOS_ISLANDS("Cocos (Keeling) Islands", "West Island", "cc", "+61", "Australian Dollar", "AUD"),
    @XmlEnumValue("Colombia")
    COLOMBIA("Colombia", "Bogota", "co", "+57", "Colombian Peso", "COP"),
    @XmlEnumValue("Comoros")
    COMOROS("Comoros", "Moroni", "km", "+269", "Comoros Franc", "KMF"),
    @XmlEnumValue("Congo")
    CONGO("Congo", "Brazzaville", "cg", "+242", "CFA Franc BEAC", "XAF"),
    @XmlEnumValue("Democratic Republic of Congo")
    DEMOCRATIC_REPUBLIC_OF_CONGO("Democratic Republic of Congo", "Kinshasa", "cd", "+243", "Francs", "CDF"),
    @XmlEnumValue("Cook Islands")
    COOK_ISLANDS("Cook Islands", "Avarua", "ck", "+682", "New Zealand Dollar", "NZD"),
    @XmlEnumValue("Costa Rica")
    COSTA_RICA("Costa Rica", "San Jose", "cr", "+506", "Costa Rican Colon", "CRC"),
    @XmlEnumValue("Croatia")
    CROATIA("Croatia", "Zagreb", "hr", "+385", "Croatian Kuna", "HRK"),
    @XmlEnumValue("Cuba")
    CUBA("Cuba", "Havana", "cu", "+53", "Cuban Peso", "CUP"),
    @XmlEnumValue("Cyprus")
    CYPRUS("Cyprus", "Nicosia", "cy", "+357", "Cyprus Pound", "CYP"),
    @XmlEnumValue("Czech Republic")
    CZECH_REPUBLIC("Czech Republic", "Prague", "cz", "+420", "Czech Koruna", "CZK"),
    @XmlEnumValue("Denmark")
    DENMARK("Denmark", "Copenhagen", "dk", "+45", "Danish Krone", "DKK"),
    @XmlEnumValue("Djibouti")
    DJIBOUTI("Djibouti", "Djibouti", "dj", "+253", "Djibouti Franc", "DJF"),
    @XmlEnumValue("Dominica")
    DOMINICA("Dominica", "Roseau", "dm", "+1767", "East Caribbean Dollar", "XCD"),
    @XmlEnumValue("Dominican Republic")
    DOMINICAN_REPUBLIC("Dominican Republic", "Santo Domingo", "do", "+809", "Dominican Peso", "DOP"),
    @XmlEnumValue("Ecuador")
    ECUADOR("Ecuador", "Quito", "ec", "+593", "Ecuador Sucre", "ECS"),
    @XmlEnumValue("Egypt")
    EGYPT("Egypt", "Cairo", "eg", "+20", "Egyptian Pound", "EGP"),
    @XmlEnumValue("El Salvador")
    EL_SALVADOR("El Salvador", "San Salvador", "sv", "+503", "El Salvador Colon", "SVC"),
    @XmlEnumValue("Equatorial Guinea")
    EQUATORIAL_GUINEA("Equatorial Guinea", "Malabo", "gq", "+240", "CFA Franc BEAC", "XAF"),
    @XmlEnumValue("Eritrea")
    ERITREA("Eritrea", "Asmara", "er", "+291", "Eritrean Nakfa", "ERN"),
    @XmlEnumValue("Estonia")
    ESTONIA("Estonia", "Tallinn", "ee", "+372", "Estonian Kroon", "EEK"),
    @XmlEnumValue("Ethiopia")
    ETHIOPIA("Ethiopia", "Addis Ababa", "et", "+251", "Ethiopian Birr", "ETB"),
    @XmlEnumValue("Falkland Islands")
    FALKLAND_ISLANDS("Falkland Islands", "Stanley", "fk", "+500", "Falkland Islands Pound", "FKP"),
    @XmlEnumValue("Faroe Islands")
    FAROE_ISLANDS("Faroe Islands", "Torshavn", "fo", "+298", "Danish Krone", "DKK"),
    @XmlEnumValue("Fiji")
    FIJI("Fiji", "Suva", "fj", "+679", "Fiji Dollar", "FJD"),
    @XmlEnumValue("Finland")
    FINLAND("Finland", "Helsinki", "fi", "+358", "Euro", "EUR"),
    @XmlEnumValue("France")
    FRANCE("France", "Paris", "fr", "+33", "Euro", "EUR"),
    @XmlEnumValue("French Guiana")
    FRENCH_GUIANA("French Guiana", "Cayenne", "gf", "+594", "Euro", "EUR"),
    @XmlEnumValue("Gabon")
    GABON("Gabon", "Libreville", "ga", "+241", "CFA Franc BEAC", "XAF"),
    @XmlEnumValue("Gambia")
    GAMBIA("Gambia", "Banjul", "gm", "+220", "Gambian Dalasi", "GMD"),
    @XmlEnumValue("Georgia")
    GEORGIA("Georgia", "Tbilisi", "ge", "+995", "Georgian Lari", "GEL"),
    @XmlEnumValue("Germany")
    GERMANY("Germany", "Berlin", "de", "+49", "Euro", "EUR"),
    @XmlEnumValue("Ghana")
    GHANA("Ghana", "Accra", "gh", "+233", "Ghanaian Cedi", "GHC"),
    @XmlEnumValue("Gibraltar")
    GIBRALTAR("Gibraltar", "Gibraltar", "gi", "+350", "Gibraltar Pound", "GIP"),
    @XmlEnumValue("Great Britain")
    GREAT_BRITAIN("Great Britain", "London", "gb", "+44", "Pound Sterling", "GBP"),
    @XmlEnumValue("Greece")
    GREECE("Greece", "Athens", "gr", "+30", "Euro", "EUR"),
    @XmlEnumValue("Greenland")
    GREENLAND("Greenland", "Godthab", "gl", "+299", "Danish Krone", "DKK"),
    @XmlEnumValue("Grenada")
    GRENADA("Grenada", "St. George's", "gd", "+1473", "East Carribean Dollar", "XCD"),
    @XmlEnumValue("Guadeloupe")
    GUADELOUPE("Guadeloupe (French)", "Basse-Terre", "gp", "+590", "Euro", "EUR"),
    @XmlEnumValue("Guam")
    GUAM("Guam (USA)", "Agana", "gu", "+1671", "US Dollar", "USD"),
    @XmlEnumValue("Guatemala")
    GUATEMALA("Guatemala", "Guatemala City", "gt", "+502", "Guatemalan Quetzal", "QTQ"),
    @XmlEnumValue("Guernsey")
    GUERNSEY("Guernsey", "St. Peter Port", "gg", "", "Pound Sterling", "GBP"),
    @XmlEnumValue("Guinea")
    GUINEA("Guinea", "Conakry", "gn", "+224", "Guinea Franc", "GNF"),
    @XmlEnumValue("Guinea Bissau")
    GUINEA_BISSAU("Guinea Bissau", "Bissau", "gw", "+245", "Guinea-Bissau Peso", "GWP"),
    @XmlEnumValue("Guyana")
    GUYANA("Guyana", "Georgetown", "gy", "+592", "Guyana Dollar", "GYD"),
    @XmlEnumValue("Haiti")
    HAITI("Haiti", "Port-au-Prince", "ht", "+509", "Haitian Gourde", "HTG"),
    @XmlEnumValue("Honduras")
    HONDURAS("Honduras", "Tegucigalpa", "hn", "+504", "Honduran Lempira", "HNL"),
    @XmlEnumValue("Hong Kong")
    HONG_KONG("Hong Kong", "Victoria", "hk", "+852", "Hong Kong Dollar", "HKD"),
    @XmlEnumValue("Hungary")
    HUNGARY("Hungary", "Budapest", "hu", "+36", "Hungarian Forint", "HUF"),
    @XmlEnumValue("Iceland")
    ICELAND("Iceland", "Reykjavik", "is", "+354", "Iceland Krona", "ISK"),
    @XmlEnumValue("India")
    INDIA("India", "New Delhi", "in", "+91", "Indian Rupee", "INR"),
    @XmlEnumValue("Indonesia")
    INDONESIA("Indonesia", "Jakarta", "id", "+62", "Indonesian Rupiah", "IDR"),
    @XmlEnumValue("Iran")
    IRAN("Iran", "Tehran", "ir", "+98", "Iranian Rial", "IRR"),
    @XmlEnumValue("Iraq")
    IRAQ("Iraq", "Baghdad", "iq", "+964", "Iraqi Dinar", "IQD"),
    @XmlEnumValue("Ireland")
    IRELAND("Ireland", "Dublin", "ie", "+353", "Euro", "EUR"),
    @XmlEnumValue("Isle of Man")
    ISLE_OF_MAN("Isle of Man", "Douglas", "im", "", "Pound Sterling", "GBP"),
    @XmlEnumValue("Israel")
    ISRAEL("Israel", "Jerusalem", "il", "+972", "Israeli New Shekel", "ILS"),
    @XmlEnumValue("Italy")
    ITALY("Italy", "Rome", "it", "+39", "Euro", "EUR"),
    @XmlEnumValue("Ivory Coast")
    IVORY_COAST("Ivory Coast", "Abidjan", "ci", "+225", "CFA Franc BCEAO", "XOF"),
    @XmlEnumValue("Jamaica")
    JAMAICA("Jamaica", "Kingston", "jm", "+1876", "Jamaican Dollar", "JMD"),
    @XmlEnumValue("Japan")
    JAPAN("Japan", "Tokyo", "jp", "+81", "Japanese Yen", "JPY"),
    @XmlEnumValue("Jersey")
    JERSEY("Jersey", "Saint Helier", "je", "", "Pound Sterling", "GBP"),
    @XmlEnumValue("Jordan")
    JORDAN("Jordan", "Amman", "jo", "+962", "Jordanian Dinar", "JOD"),
    @XmlEnumValue("Kazakhstan")
    KAZAKHSTAN("Kazakhstan", "Astana", "kz", "+7", "Kazakhstan Tenge", "KZT"),
    @XmlEnumValue("Kenya")
    KENYA("Kenya", "Nairobi", "ke", "+254", "Kenyan Shilling", "KES"),
    @XmlEnumValue("Kiribati")
    KIRIBATI("Kiribati", "Tarawa", "ki", "+686", "Australian Dollar", "AUD"),
    @XmlEnumValue("North Korea")
    KOREA_NORTH("Korea-North", "Pyongyang", "kp", "+850", "North Korean Won", "KPW"),
    @XmlEnumValue("South Korea")
    KOREA_SOUTH("Korea-South", "Seoul", "kr", "+82", "Korean Won", "KRW"),
    @XmlEnumValue("Kuwait")
    KUWAIT("Kuwait", "Kuwait City", "kw", "+965", "Kuwaiti Dinar", "KWD"),
    @XmlEnumValue("Kyrgyzstan")
    KYRGYZSTAN("Kyrgyzstan", "Bishkek", "kg", "+996", "Som", "KGS"),
    @XmlEnumValue("Laos")
    LAOS("Laos", "Vientiane", "la", "+856", "Lao Kip", "LAK"),
    @XmlEnumValue("Latvia")
    LATVIA("Latvia", "Riga", "lv", "+371", "Latvian Lats", "LVL"),
    @XmlEnumValue("Lebanon")
    LEBANON("Lebanon", "Beirut", "lb", "+961", "Lebanese Pound", "LBP"),
    @XmlEnumValue("Lesotho")
    LESOTHO("Lesotho", "Maseru", "ls", "+266", "Lesotho Loti", "LSL"),
    @XmlEnumValue("Liberia")
    LIBERIA("Liberia", "Monrovia", "lr", "+231", "Liberian Dollar", "LRD"),
    @XmlEnumValue("Libya")
    LIBYA("Libya", "Tripoli", "ly", "+218", "Libyan Dinar", "LYD"),
    @XmlEnumValue("Liechtenstein")
    LIECHTENSTEIN("Liechtenstein", "Vaduz", "li", "+423", "Swiss Franc", "CHF"),
    @XmlEnumValue("Lithuania")
    LITHUANIA("Lithuania", "Vilnius", "lt", "+370", "Lithuanian Litas", "LTL"),
    @XmlEnumValue("Luxembourg")
    LUXEMBOURG("Luxembourg", "Luxembourg", "lu", "+352", "Euro", "EUR"),
    @XmlEnumValue("Macau")
    MACAU("Macau", "Macau", "mo", "+853", "Macau Pataca", "MOP"),
    @XmlEnumValue("Macedonia")
    MACEDONIA("Macedonia", "Skopje", "mk", "+389", "Denar", "MKD"),
    @XmlEnumValue("Madagascar")
    MADAGASCAR("Madagascar", "Antananarivo", "mg", "+261", "Malagasy Franc", "MGF"),
    @XmlEnumValue("Malawi")
    MALAWI("Malawi", "Lilongwe", "mw", "+265", "Malawi Kwacha", "MWK"),
    @XmlEnumValue("Malaysia")
    MALAYSIA("Malaysia", "Kuala Lumpur", "my", "+60", "Malaysian Ringgit", "MYR"),
    @XmlEnumValue("Maldives")
    MALDIVES("Maldives", "Male", "mv", "+960", "Maldive Rufiyaa", "MVR"),
    @XmlEnumValue("Mali")
    MALI("Mali", "Bamako", "ml", "+223", "CFA Franc BCEAO", "XOF"),
    @XmlEnumValue("Malta")
    MALTA("Malta", "Valletta", "mt", "+356", "Maltese Lira", "MTL"),
    @XmlEnumValue("Marshall Islands")
    MARSHALL_ISLANDS("Marshall Islands", "Majuro", "mh", "+692", "US Dollar", "USD"),
    @XmlEnumValue("Martinique")
    MARTINIQUE("Martinique (French)", "Fort-de-France", "mq", "+596", "Euro", "EUR"),
    @XmlEnumValue("Mauritania")
    MAURITANIA("Mauritania", "Nouakchott", "mr", "+222", "Mauritanian Ouguiya", "MRO"),
    @XmlEnumValue("Mauritius")
    MAURITIUS("Mauritius", "Port Louis", "mu", "+230", "Mauritius Rupee", "MUR"),
    @XmlEnumValue("Mayotte")
    MAYOTTE("Mayotte", "Dzaoudzi", "yt", "+269", "Euro", "EUR"),
    @XmlEnumValue("Mexico")
    MEXICO("Mexico", "Mexico City", "mx", "+52", "Mexican Nuevo Peso", "MXN"),
    @XmlEnumValue("Micronesia")
    MICRONESIA("Micronesia", "Palikir", "fm", "+691", "US Dollar", "USD"),
    @XmlEnumValue("Moldova")
    MOLDOVA("Moldova", "Kishinev", "md", "+373", "Moldovan Leu", "MDL"),
    @XmlEnumValue("Monaco")
    MONACO("Monaco", "Monaco", "mc", "+377", "Euro", "EUR"),
    @XmlEnumValue("Mongolia")
    MONGOLIA("Mongolia", "Ulan Bator", "mn", "+976", "Mongolian Tugrik", "MNT"),
    @XmlEnumValue("Montenegro")
    MONTENEGRO("Montenegro", "Podgorica", "me", "+382", "Euro", "EUR"),
    @XmlEnumValue("Montserrat")
    MONTSERRAT("Montserrat", "Plymouth", "ms", "+1664", "East Caribbean Dollar", "XCD"),
    @XmlEnumValue("Morocco")
    MOROCCO("Morocco", "Rabat", "ma", "+212", "Moroccan Dirham", "MAD"),
    @XmlEnumValue("Mozambique")
    MOZAMBIQUE("Mozambique", "Maputo", "mz", "+258", "Mozambique Metical", "MZM"),
    @XmlEnumValue("Myanmar")
    MYANMAR("Myanmar", "Naypyidaw", "mm", "+95", "Myanmar Kyat", "MMK"),
    @XmlEnumValue("Namibia")
    NAMIBIA("Namibia", "Windhoek", "na", "+264", "Namibian Dollar", "NAD"),
    @XmlEnumValue("Nauru")
    NAURU("Nauru", "Yaren", "nr", "+674", "Australian Dollar", "AUD"),
    @XmlEnumValue("Nepal")
    NEPAL("Nepal", "Kathmandu", "np", "+977", "Nepalese Rupee", "NPR"),
    @XmlEnumValue("Netherlands")
    NETHERLANDS("Netherlands", "Amsterdam", "nl", "+31", "Euro", "EUR"),
    @XmlEnumValue("Netherlands Antilles")
    NETHERLANDS_ANTILLES(
            "Netherlands Antilles",
            "Willemstad",
            "an",
            "+599",
            "Netherlands Antillean Guilder",
            "ANG"),
    @XmlEnumValue("New Caledonia")
    NEW_CALEDONIA("New Caledonia (French)", "Noumea", "nc", "+687", "CFP Franc", "XPF"),
    @XmlEnumValue("New Zealand")
    NEW_ZEALAND("New Zealand", "Wellington", "nz", "+64", "New Zealand Dollar", "NZD"),
    @XmlEnumValue("Nicaragua")
    NICARAGUA("Nicaragua", "Managua", "ni", "+505", "Nicaraguan Cordoba Oro", "NIC"),
    @XmlEnumValue("Niger")
    NIGER("Niger", "Niamey", "ne", "+227", "CFA Franc BCEAO", "XOF"),
    @XmlEnumValue("Nigeria")
    NIGERIA("Nigeria", "Lagos", "ng", "+234", "Nigerian Naira", "NGN"),
    @XmlEnumValue("Niue")
    NIUE("Niue", "Alofi", "nu", "+683", "New Zealand Dollar", "NZD"),
    @XmlEnumValue("Norfolk Island")
    NORFOLK_ISLAND("Norfolk Island", "Kingston", "nf", "+672", "Australian Dollar", "AUD"),
    @XmlEnumValue("Northern Mariana Islands")
    NORTHERN_MARIANA_ISLANDS("Northern Mariana Islands", "Saipan", "mp", "+670", "US Dollar", "USD"),
    @XmlEnumValue("Norway")
    NORWAY("Norway", "Oslo", "no", "+47", "Norwegian Krone", "NOK"),
    @XmlEnumValue("Oman")
    OMAN("Oman", "Muscat", "om", "+968", "Omani Rial", "OMR"),
    @XmlEnumValue("Pakistan")
    PAKISTAN("Pakistan", "Islamabad", "pk", "+92", "Pakistan Rupee", "PKR"),
    @XmlEnumValue("Palau")
    PALAU("Palau", "Koror", "pw", "+680", "US Dollar", "USD"),
    @XmlEnumValue("Panama")
    PANAMA("Panama", "Panama City", "pa", "+507", "Panamanian Balboa", "PAB"),
    @XmlEnumValue("Papua New Guinea")
    PAPUA_NEW_GUINEA("Papua New Guinea", "Port Moresby", "pg", "+675", "Papua New Guinea Kina", "PGK"),
    @XmlEnumValue("Paraguay")
    PARAGUAY("Paraguay", "Asuncion", "py", "+595", "Paraguay Guarani", "PYG"),
    @XmlEnumValue("Peru")
    PERU("Peru", "Lima", "pe", "+51", "Peruvian Nuevo Sol", "PEN"),
    @XmlEnumValue("Philippines")
    PHILIPPINES("Philippines", "Manila", "ph", "+63", "Philippine Peso", "PHP"),
    @XmlEnumValue("Pitcairn Island")
    PITCAIRN_ISLAND("Pitcairn Island", "Adamstown", "pn", "", "New Zealand Dollar", "NZD"),
    @XmlEnumValue("Poland")
    POLAND("Poland", "Warsaw", "pl", "+48", "Polish Zloty", "PLZ"),
    @XmlEnumValue("Polynesia")
    POLYNESIA("Polynesia (French)", "Papeete", "pf", "+689", "CFP Franc", "XPF"),
    @XmlEnumValue("Portugal")
    PORTUGAL("Portugal", "Lisbon", "pt", "+351", "Euro", "EUR"),
    @XmlEnumValue("Puerto Rico")
    PUERTO_RICO("Puerto Rico", "San Juan", "pr", "+1787", "US Dollar", "USD"),
    @XmlEnumValue("Qatar")
    QATAR("Qatar", "Doha", "qa", "+974", "Qatari Rial", "QAR"),
    @XmlEnumValue("Reunion")
    REUNION("Reunion (French)", "Saint-Denis", "re", "+262", "Euro", "EUR"),
    @XmlEnumValue("Romania")
    ROMANIA("Romania", "Bucharest", "ro", "+40", "Romanian Leu", "ROL"),
    @XmlEnumValue("Russia")
    RUSSIA("Russia", "Moscow", "ru", "+7", "Russian Ruble", "RUR"),
    @XmlEnumValue("Rwanda")
    RWANDA("Rwanda", "Kigali", "rw", "+250", "Rwanda Franc", "RWF"),
    @XmlEnumValue("Saint Helena")
    SAINT_HELENA("Saint Helena", "Jamestown", "sh", "+290", "St. Helena Pound", "SHP"),
    @XmlEnumValue("Saint Kitts and Nevis Anguilla")
    SAINT_KITTS_AND_NEVIS_ANGUILLA(
            "Saint Kitts & Nevis Anguilla",
            "Basseterre",
            "kn",
            "+1869",
            "East Caribbean Dollar",
            "XCD"),
    @XmlEnumValue("Saint Lucia")
    SAINT_LUCIA("Saint Lucia", "Castries", "lc", "+1758", "East Caribbean Dollar", "XCD"),
    @XmlEnumValue("Saint Pierre and Miquelon")
    SAINT_PIERRE_AND_MIQUELON("Saint Pierre and Miquelon", "St. Pierre", "pm", "+508", "Euro", "EUR"),
    @XmlEnumValue("Saint Vincent and Grenadines")
    SAINT_VINCENT_AND_GRENADINES(
            "Saint Vincent & Grenadines",
            "Kingstown",
            "vc",
            "+1784",
            "East Caribbean Dollar",
            "XCD"),
    @XmlEnumValue("Samoa")
    SAMOA("Samoa", "Apia", "ws", "+684", "Samoan Tala", "WST"),
    @XmlEnumValue("San Marino")
    SAN_MARINO("San Marino", "San Marino", "sm", "+378", "Italian Lira", "ITL"),
    @XmlEnumValue("Sao Tome and Principe")
    SAO_TOME_AND_PRINCIPE("Sao Tome and Principe", "Sao Tome", "st", "+239", "Dobra", "STD"),
    @XmlEnumValue("Saudi Arabia")
    SAUDI_ARABIA("Saudi Arabia", "Riyadh", "sa", "+966", "Saudi Riyal", "SAR"),
    @XmlEnumValue("Senegal")
    SENEGAL("Senegal", "Dakar", "sn", "+221", "CFA Franc BCEAO", "XOF"),
    @XmlEnumValue("Serbia")
    SERBIA("Serbia", "Belgrade", "rs", "+381", "Dinar", "RSD"),
    @XmlEnumValue("Seychelles")
    SEYCHELLES("Seychelles", "Victoria", "sc", "+248", "Seychelles Rupee", "SCR"),
    @XmlEnumValue("Sierra Leone")
    SIERRA_LEONE("Sierra Leone", "Freetown", "sl", "+232", "Sierra Leone Leone", "SLL"),
    @XmlEnumValue("Singapore")
    SINGAPORE("Singapore", "Singapore", "sg", "+65", "Singapore Dollar", "SGD"),
    @XmlEnumValue("Slovakia")
    SLOVAKIA("Slovakia", "Bratislava", "sk", "+421", "Slovak Koruna", "SKK"),
    @XmlEnumValue("Slovenia")
    SLOVENIA("Slovenia", "Ljubljana", "si", "+386", "Slovenian Tolar", "SIT"),
    @XmlEnumValue("Solomon Islands")
    SOLOMON_ISLANDS("Solomon Islands", "Honiara", "sb", "+677", "Solomon Islands Dollar", "SBD"),
    @XmlEnumValue("Somalia")
    SOMALIA("Somalia", "Mogadishu", "so", "+252", "Somali Shilling", "SOD"),
    @XmlEnumValue("South Africa")
    SOUTH_AFRICA("South Africa", "Pretoria", "za", "+27", "South African Rand", "ZAR"),
    @XmlEnumValue("Spain")
    SPAIN("Spain", "Madrid", "es", "+34", "Euro", "EUR"),
    @XmlEnumValue("Sri Lanka")
    SRI_LANKA("Sri Lanka", "Colombo", "lk", "+94", "Sri Lanka Rupee", "LKR"),
    @XmlEnumValue("Sudan")
    SUDAN("Sudan", "Khartoum", "sd", "+249", "Sudanese Dinar", "SDD"),
    @XmlEnumValue("Suriname")
    SURINAME("Suriname", "Paramaribo", "sr", "+597", "Surinam Guilder", "SRG"),
    @XmlEnumValue("Svalbard and Jan Mayen Islands")
    SVALBARD_AND_JAN_MAYEN_ISLANDS(
            "Svalbard and Jan Mayen Islands",
            "Longyearbyen",
            "sj",
            "",
            "Norwegian Krone",
            "NOK"),
    @XmlEnumValue("Swaziland")
    SWAZILAND("Swaziland", "Mbabane", "sz", "+268", "Swaziland Lilangeni", "SZL"),
    @XmlEnumValue("Sweden")
    SWEDEN("Sweden", "Stockholm", "se", "+46", "Swedish Krona", "SEK"),
    @XmlEnumValue("Switzerland")
    SWITZERLAND("Switzerland", "Bern", "ch", "+41", "Swiss Franc", "CHF"),
    @XmlEnumValue("Syria")
    SYRIA("Syria", "Damascus", "sy", "+963", "Syrian Pound", "SYP"),
    @XmlEnumValue("Taiwan")
    TAIWAN("Taiwan", "Taipei", "tw", "+886", "Taiwan Dollar", "TWD"),
    @XmlEnumValue("Tajikistan")
    TAJIKISTAN("Tajikistan", "Dushanbe", "tj", "+992", "Tajik Ruble", "TJR"),
    @XmlEnumValue("Tanzania")
    TANZANIA("Tanzania", "Dodoma", "tz", "+255", "Tanzanian Shilling", "TZS"),
    @XmlEnumValue("Thailand")
    THAILAND("Thailand", "Bangkok", "th", "+66", "Thai Baht", "THB"),
    @XmlEnumValue("Togo")
    TOGO("Togo", "Lome", "tg", "+228", "CFA Franc BCEAO", "XOF"),
    @XmlEnumValue("Tonga")
    TONGA("Tonga", "Nuku'alofa", "to", "+676", "Tongan Pa'anga", "TOP"),
    @XmlEnumValue("Trinidad and Tobago")
    TRINIDAD_AND_TOBAGO(
            "Trinidad and Tobago",
            "Port of Spain",
            "tt",
            "+1868",
            "Trinidad and Tobago Dollar",
            "TTD"),
    @XmlEnumValue("Tunisia")
    TUNISIA("Tunisia", "Tunis", "tn", "+216", "Tunisian Dollar", "TND"),
    @XmlEnumValue("Turkey")
    TURKEY("Turkey", "Ankara", "tr", "+90", "Turkish Lira", "TRL"),
    @XmlEnumValue("Turkmenistan")
    TURKMENISTAN("Turkmenistan", "Ashgabat", "tm", "+993", "Manat", "TMM"),
    @XmlEnumValue("Turks and Caicos Islands")
    TURKS_AND_CAICOS_ISLANDS("Turks and Caicos Islands", "Grand Turk", "tc", "+1649", "US Dollar", "USD"),
    @XmlEnumValue("Tuvalu")
    TUVALU("Tuvalu", "Funafuti", "tv", "+688", "Australian Dollar", "AUD"),
    @XmlEnumValue("United Kingdom")
    UNITED_KINGDOM("United Kingdom", "London", "uk", "+44", "Pound Sterling", "GBP"),
    @XmlEnumValue("Uganda")
    UGANDA("Uganda", "Kampala", "ug", "+256", "Uganda Shilling", "UGS"),
    @XmlEnumValue("Ukraine")
    UKRAINE("Ukraine", "Kiev", "ua", "+380", "Ukraine Hryvnia", "UAG"),
    @XmlEnumValue("United Arab Emirates")
    UNITED_ARAB_EMIRATES("United Arab Emirates", "Abu Dhabi", "ae", "+971", "Arab Emirates Dirham", "AED"),
    @XmlEnumValue("Uruguay")
    URUGUAY("Uruguay", "Montevideo", "uy", "+598", "Uruguayan Peso", "UYP"),
    @XmlEnumValue("United States of America")
    UNITED_STATES_OF_AMERICA("United States of America", "Washington", "us", "+1", "US Dollar", "USD"),
    @XmlEnumValue("Uzbekistan")
    UZBEKISTAN("Uzbekistan", "Tashkent", "uz", "+998", "Uzbekistan Sum", "UZS"),
    @XmlEnumValue("Vanuatu")
    VANUATU("Vanuatu", "Port Vila", "vu", "+678", "Vanuatu Vatu", "VUV"),
    @XmlEnumValue("Vatican")
    VATICAN("Vatican", "Vatican City", "va", "+39", "Euro", "EUR"),
    @XmlEnumValue("Venezuela")
    VENEZUELA("Venezuela", "Caracas", "ve", "+58", "Venezuelan Bolivar", "VUB"),
    @XmlEnumValue("Vietnam")
    VIETNAM("Vietnam", "Hanoi", "vn", "+84", "Vietnamese Dong", "VND"),
    @XmlEnumValue("Virgin Islands Uk")
    VIRGIN_ISLANDS_UK("Virgin Islands (British)", "Road Town", "vg", "+1284", "US Dollar", "USD"),
    @XmlEnumValue("Virgin Islands USA")
    VIRGIN_ISLANDS_USA("Virgin Islands (USA)", "Charlotte Amalie", "vi", "+1340", "US Dollar", "USD"),
    @XmlEnumValue("Wallis and Futuna Islands")
    WALLIS_AND_FUTUNA_ISLANDS("Wallis and Futuna Islands", "Mata-Utu", "wf", "+681", "CFP Franc", "XPF"),
    @XmlEnumValue("Western Sahara")
    WESTERN_SAHARA("Western Sahara", "El Aaiun", "eh", "", "Moroccan Dirham", "MAD"),
    @XmlEnumValue("Yemen")
    YEMEN("Yemen", "San'a", "ye", "+967", "Yemeni Rial", "YER"),
    @XmlEnumValue("Zambia")
    ZAMBIA("Zambia", "Lusaka", "zm", "+260", "Zambian Kwacha", "ZMK"),
    @XmlEnumValue("Zimbabwe")
    ZIMBABWE("Zimbabwe", "Harare", "zw", "+263", "Zimbabwe Dollar", "ZWD"),
    @XmlEnumValue("Unknown")
    UNKNOWN("Unknown", "", "", "", "", ""),
    @XmlEnumValue("Illegal")
    ILLEGAL("Illegal", "", "", "", "", "");

    private final String __country;
    private final String __capitol;
    private final String __tld;
    private final String __dialingCode;
    private final String __monitaryUnitName;
    private final String __monitaryUnitAbreviation;

    /**
     * @param country
     * @param capitol
     * @param tld
     * @param code
     * @param monetaryUnit
     * @param monitaryUnitAbbreviation
     */
    private NationalityType(
            final String country,
            final String capitol,
            final String tld,
            final String code,
            final String monetaryUnit,
            final String monitaryUnitAbbreviation) {
        __country = country;
        __capitol = capitol;
        __tld = tld;
        __dialingCode = code;
        __monitaryUnitName = monetaryUnit;
        __monitaryUnitAbreviation = monitaryUnitAbbreviation;
    }

    /**
     * @return
     */
    public String country() {
        return __country;
    }

    /**
     * @return
     */
    public String capitol() {
        return __capitol;
    }

    /**
     * @return
     */
    public String TLD() {
        return __tld;
    }

    /**
     * @return
     */
    public String dialingCode() {
        return __dialingCode;
    }

    /**
     * @return
     */
    public String monitaryUnitName() {
        return __monitaryUnitName;
    }

    /**
     * @return
     */
    public String monitaryUnitAbreviation() {
        return __monitaryUnitAbreviation;
    }

    /** {@inheritDoc} */
    @Override
    public String toString() {
        return toStringBuilder(this)
                .append("Country", __country)
                .append("Capitol", __capitol)
                .append("Top Level Domain", __tld)
                .append("International Dialing Code", __dialingCode)
                .append("Currency", __monitaryUnitName)
                .append("Currency Abbreviation", __monitaryUnitAbreviation)
                .build();
    }
}
