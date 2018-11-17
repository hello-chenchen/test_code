import urllib.request
import json

#获取id_list.txt中的数据，并放在list中
id_list_file = open("test.txt", "r")
book_id_list = list()
for line in id_list_file:
    book_id_list.append(line.strip())

#获取id_blacklist.txt中的数据，并放在list中
black_list_file = open("test1.txt", "r")
for line in black_list_file:
    value = line.strip()
    #当book_id_list中存在黑名单中的数据，则忽略
    if value in book_id_list:
        book_id_list.remove(value)

#爬取接口信息，并写入文件中
result_file = open("result.txt", "w", encoding='utf-8')
for line in book_id_list:
    url = "https://api.douban.com/v2/book/" + line.strip()
    res_data = urllib.request.urlopen(url)
    response = res_data.read().decode("utf-8")
    json_obj = json.loads(response)
    result = ("id:" + line + " title:" + str(json_obj['title'])
     + " author:" + str(json_obj['author']) + " summary:" + json_obj['summary'])
    result_file.write(result + '\n')
id_list_file.close()
result_file.close()
