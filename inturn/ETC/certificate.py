import requests
from bs4 import BeautifulSoup

c1 = ["146","145","141","111","021","171","167","162","161","241","173","144","175","082","232","083","212","061","252","023","071","024","191","122","221","251","244","262","101","174","091","182","192","121","231","243","166","201","202","211","222","143","131","164","151","163","242","142","213","172","165","181","261"]
c2 = ["P200","R139","N004","R500","N003","R020","R120","N002"]
# 대한상공회의소 : P200
# 영화진흥위원회 : R139
# 한국광해관리공단 : N004
# 한국기술자격검정원 : R500
# 한국방송통신전파진흥원 : N003
# 한국원자력안전기술원 : R020
# 한국인터넷진흥원 : R120
# 한국콘텐츠진흥원 : N002
url1="http://q-net.or.kr/crf005.do?id=crf00501s01&gSite=Q&gId=&div=1&obligFldCd=";
url2="http://q-net.or.kr/crf005.do?id=crf00501s01&gSite=Q&gId=&div=2&examInstiCd="

for code in c1 :
    req = requests.get(url1 + code)
    html = req.text
    soup = BeautifulSoup(html, 'html.parser')
    certificate_tag = soup.select('li > a')
    for certificate_name in certificate_tag:
        print(certificate_name.text[2:])
print("/////////////////////////")
for i in range(0,len(c2)) :
    req = requests.get(url2 + c2[i])
    html = req.text
    soup = BeautifulSoup(html, 'html.parser')
    certificate_tag = soup.select('li > a')
    for certificate_name in certificate_tag:
        print(certificate_name.text[2:])
    print("/////////////////////////")