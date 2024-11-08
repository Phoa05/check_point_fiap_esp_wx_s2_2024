# Notas do Professor

- Drosophila melanogaster

## Rodando MD5 nos arquivos

```bash
fllsouto in ~/Desktop/Drosophila_melanogaster_ncbi_dataset λ cat md5sum.txt 
ae176db497f6c19aa0982ff68936854d  ncbi_dataset/data/data_summary.tsv
5ce4bec47f1dec78aff1d5b1278815d3  ncbi_dataset/data/assembly_data_report.jsonl
ec91b390e19aaf5dc058637c67e8c235  ncbi_dataset/data/GCA_000001215.4/genomic.gbff
553c7998538c466b36af46a266ad5390  ncbi_dataset/data/GCA_000001215.4/GCA_000001215.4_Release_6_plus_ISO1_MT_genomic.fna
83916ca52fa826f58a934fe6c5aa3165  ncbi_dataset/data/GCA_000001215.4/genomic.gtf
e2b9001fbc272add3f6988d1262139b9  ncbi_dataset/data/GCA_000001215.4/genomic.gff
311a98458dc9f453978ec70fc0dad656  ncbi_dataset/data/GCA_000001215.4/cds_from_genomic.fna
6813d353a4300d16521a694286ea3d13  ncbi_dataset/data/GCA_000001215.4/protein.faa
0cb5d52de42726409705eeb7ec3b5c98  ncbi_dataset/data/GCF_000001215.4/genomic.gbff
a201b53b7eab2eb161671e4b3ae670a0  ncbi_dataset/data/GCF_000001215.4/GCF_000001215.4_Release_6_plus_ISO1_MT_genomic.fna
a79876baf5767a9d6a5fe2cbb93a25f8  ncbi_dataset/data/GCF_000001215.4/genomic.gtf
399b4ac37cc123b724895334be589fdc  ncbi_dataset/data/GCF_000001215.4/genomic.gff
76e78617dd3457f256f884ae68933372  ncbi_dataset/data/GCF_000001215.4/rna.fna
68c12a0f00236e5e21c301823c81c47f  ncbi_dataset/data/GCF_000001215.4/cds_from_genomic.fna
9dd2590525454a6cc4e0fcf8ee094ee7  ncbi_dataset/data/GCF_000001215.4/protein.faa
8e258a9de465fdaf61948a0dfa1e9880  ncbi_dataset/data/GCA_000001215.4/sequence_report.jsonl
9f04dd6eb941def70eda10e73d419964  ncbi_dataset/data/GCF_000001215.4/sequence_report.jsonl
78f0884d017baed37891609f661e439a  ncbi_dataset/data/dataset_catalog.json
fllsouto in ~/Desktop/Drosophila_melanogaster_ncbi_dataset λ md5sum ncbi_dataset/data/data_summary.tsv 
ae176db497f6c19aa0982ff68936854d  ncbi_dataset/data/data_summary.tsv
fllsouto in ~/Desktop/Drosophila_melanogaster_ncbi_dataset λ 

```

## Genome banks

- https://genome.ucsc.edu/cgi-bin/hgGateway
- https://hgdownload.soe.ucsc.edu/downloads.html#fruitfly

## Linux Setup

- https://github.com/ohmyzsh/ohmyzsh/tree/master/plugins/asdf
- https://github.com/asdf-community/asdf-python
- https://github.com/pyenv/pyenv/tree/master/plugins/python-build
- https://www.python.org/downloads/source/
- 

```bash
$ asdf install python 3.11.10
> ...


$ asdf global python 3.11.10
> ...

$ python -V
> Python 3.11.10


```