package main;

public enum Goddess {
    YURINA(new String[] { "참", "일섬", "자루치기", "거합", "기백", "압도", "기염만장" },
            new String[] { "월영락", "해안의 파랑일며", "쪽배에서 쉬노니", "아마네 유리나의 저력" }),
    SAINE(new String[] { "팔방 휘두르기", "후려베기", "무게추", "간파", "권역", "충음벽", "무음벽" },
            new String[] { "율동호극", "항명공진", "음무쇄빙", "히사메 사이네의 최후의 종극" }),
    HIMIKA(new String[] { "슛", "레피드 파이어", "매그넘 캐논", "풀 버스트", "백스텝", "백드래프트", "스모크" },
            new String[] { "레드 불릿", "크림슨 제로", "스칼렛 이매진", "버밀리온 필드" }),
    TOKOYO(new String[] { "빗어내리기", "우아한 타격", "날뛰는 토끼", "시의 춤", "부채 뒤집기", "바람의 무대", "맑음의 무대" },
            new String[] { "영원의 꽃", "천년의 새", "무궁의 바람", "상세의 달" }),
    OBORO(new String[] { "철사", "그림자 마름", "참격난무", "닌자걸음", "유도", "분신술", "생체활성" },
            new String[] { "쿠마스케", "토비카게", "우로우오", "미카즈라" }),
    YUKIHI(new String[] { "숨긴 바늘/머금은 바늘", "숨긴 불꽃/손뼉치기", "떨쳐내기/끌어당기기", "휘두르기/푹 찌르기", "우산 돌리기", "뒷걸음질/파고들기", "인연 맺기" },
            new String[] { "흩날리는 눈꽃", "일렁이는 등불", "질척이는 속내", "빙글도는 몸짓" }),
    SHILLA(new String[] { "입론", "반론", "궤변", "인용", "선동", "장담", "논파" },
            new String[] { "완전논파", "일절이해", "천지반박", "삼라판증" }),
    HAGANE(new String[] { "원심격", "사풍진", "대지 부수기", "초반동", "원무련", "종 울리기", "인력장" },
            new String[] { "대천공 크래시", "대파종 메갈로벨", "대중력 어트랙트", "대산맥 리스펙트" }),
    CHIKAGE(new String[] { "쿠나이 던지기", "독침", "둔술", "목 베기", "독 안개", "까치발 걸음", "진흙탕" },
            new String[] { "멸등의 영혼독", "반기의 얽힌독", "윤회의 안개독", "야미쿠라 치카게가 사는 길" },
            new String[] { "마비독", "환각독", "이완독", "멸등독", "멸등독" }),
    KURURU(new String[] { "엘레키텔", "엑셀러~", "쿠루룽~", "토네~이도", "리게이너~", "모듀르~", "리플렉터" },
            new String[] { "드레~인 데빌", "빅 골~렘", "인더스트리아", "신섭장치:쿠루루식" },
            new String[] { "듀플리기어", "듀플리기어", "듀플리기어" }),
    TALIIYA(new String[] { "Burning Steam", "Waving Edge", "Shield Chrge", "Steam Cannon", "Stunt", "Roaring",
            "Turbo Switch" },
            new String[] { "Alpha-Edge", "Omega-Burst", "Thallya's Masterpiece", "Julia's BlackBox" },
            new String[] { "Form: YAKSHA", "Form: NAGA", "Form: GARUDA" }),
    RAIRA(new String[] { "짐승의 손톱", "풍뢰격", "윤회의 손톱", "바람 달리기", "풍뢰의 지혜", "울부짖기", "하늘 박차기" },
            new String[] { "뇌라풍신조", "천뢰소환진", "풍마초래공", "원환륜회선" },
            new String[] { "풍마선풍", "풍마전회", "풍마천구도" }),
    UTSURO(new String[] { "원월", "검은 파동", "수확", "중압", "그림자 날개", "그림자 벽", "유회주" },
            new String[] { "회멸", "허위", "종말", "마식" }),
    HONOKA(new String[] { "정령식", "벚꽃보라", "의기공진", "벚꽃 날개", "벚꽃 부적", "지휘", "꽁무늬바람" },
            new String[] { "가슴에 의지를", "이 깃발의 이름 아래", "사계는 다시 돌아온다", "만개한 꽃길아래" },
            new String[] { "수호령식", "돌격령식", "신령 오우카", "재생", "아련한 반짝임", "양손의 꽃을", "그리고 새로운 개막을" }),
    KORUNU(new String[] { "눈 칼날", "선회날", "검의 춤", "눈 타기", "절대영도", "동상", "서리 가시덤불" },
            new String[] { "콘루 루얀페", "레타르 레라", "우파스 툼", "포루챠르 토" }),
    YATSUHA(new String[] { "별의 손톱", "어둠의 아가리", "거울의 악마", "환영보법", "의지", "계약", "들러붙는 꽃" },
            new String[] { "두잎 거울의 재앙신", "네잎 거울의 전래동요", "여섯잎 거울의 별바다", "여덟잎 거울의 저편" }),
    HATSUMI(new String[] { "수뢰구", "수류", "강산", "해일", "준비만전", "나침반", "파도 부르기" },
            new String[] { "이사나 해역", "오요기비 포화", "카라하리 등대", "미오비키 항로" }),
    MIZUKI(new String[] { "진두", "반공", "쏘아 떨구기", "호령", "방벽", "제압전진", "전장" },
            new String[] { "하치류 천주각", "히자마루 삼중루", "타테나시 대수문", "야마시로 미즈키의 전투의 함성" },
            new String[] { "투신", "창병", "창병", "방패병", "기병" }),
    MEGUMI(new String[] { "공섬", "타척", "껍질치기", "장대 찌르기", "갈대", "봉선화", "찔레꽃" },
            new String[] { "인과율의 뿌리", "가능성의 가지", "결말의 과실", "타키가와 메구미의 손바닥" }),
    KANAWE(new String[] { "공상", "각본화", "연출화", "단행", "잔광", "즉흥", "봉살" },
            new String[] { "어렴풋한 이야기", "무수한 별빛", "이 밤을 굽이굽이 펴리라", "겨레의 머나먼 하늘" },
            new String[] { "살진", "벚꽃파도", "고동", "명전", "강조하기", "위치 잡기" }),
    KAMUWI(new String[] { "붉은 칼날", "흩날리는 칼날", "사검난인", "베어내기", "가시꿰기", "혈청난류", "피보라" },
            new String[] { "등불", "묘도", "신위", "이치" }, 
            new String[] { "새벽" }),
    RENRI(new String[] { "거짓 찌르기", "임시변통", "먹칠", "약올리는 몸짓", "뜬구름 먹기", "낚시질", "끌어 속이기" },
            new String[] { "요러하리라라", "너르로로리러", "내라라려루레", "요야마 렌리의 영락한 말로" }, 
            new String[] { "아로새긴 옷", "미츠루기 키리코의 무녀신악", "망아", "완전논파", "영원의 꽃" }),
    AKINA(new String[] { "주판알", "공갈", "교역", "투기", "산법", "판세 뒤집기", "직접금융" },
            new String[] { "개방명식절취법", "대연산과수타표", "쇠타축주수료술", "미나카미 아키나의 정확한 계산" }),
    SHISUI(new String[] { "톱날 베기", "파고드는 톱날", "반란격", "철저항전", "가시밭길", "쇳가루 휘감기", "검은 갑옷(금지)" },
            new String[] { "파드마 베기", "우팔라 찢기", "아부다 먹기", "쿠와하타 시스이가 죽는 곳" });

    private final String[] nomal;
    private final String[] special;
    private final String[] addition;

    private Goddess(String[] nomal, String[] special) {
        this.nomal = nomal;
        this.special = special;
        this.addition = null;
    }

    private Goddess(String[] nomal, String[] special, String[] addition) {
        this.nomal = nomal;
        this.special = special;
        this.addition = addition;
    }

    public String[] getNormal() {
        return nomal;
    }

    public String[] getSpecial() {
        return special;
    }

    public String[] getAddition() {
        return addition;
    }
}
