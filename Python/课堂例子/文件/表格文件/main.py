import csv
title = ["学号","姓名","语文","英语","计算机","程序"]
s1=["10101","a","58","12","95","99"]
s2=["10102","b","85","88","89","99"]
s3=["10103","c","86","82","83","88"]
s4=["10104","d","94","92","89","95"]
f1=open(".\\学生成绩信息.csv","w")
f1_csv=csv.writer(f1)
f1_csv.writerow(title)
f1_csv.writerows([s1,s2,s3,s4])
f1.close