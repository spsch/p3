import shutil
import urllib3
import zipfile
import glob
import os

URL = "http://www-eu.apache.org/dist/maven/maven-3/3.5.0/binaries/apache-maven-3.5.0-bin.zip"
dotaz = urllib3.PoolManager()

print("Starting download..")
with dotaz.request('GET', URL, preload_content=False) as response, open("apache-maven-3.5.0-bin.zip", 'wb') as outfile:
    shutil.copyfileobj(response, outfile)
response.release_conn()
print('Done, start unpacking')
mavenzip = zipfile.ZipFile('apache-maven-3.5.0-bin.zip')
mavenzip.extractall()
print('Done: here is the file')
file_dir = os.path.join('.', '*.zip')
for file_name in glob.glob(file_dir):
    if file_name.endswith('.zip'):
        print (file_name)