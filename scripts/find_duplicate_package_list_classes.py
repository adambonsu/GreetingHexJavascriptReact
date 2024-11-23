import os

def find_duplicate_package_list_classes(directory):
    package_list_files = []
    for root, _, files in os.walk(directory):
        for file in files:
            if file == 'PackageList.java':
                package_list_files.append(os.path.join(root, file))
    return package_list_files

if __name__ == "__main__":
    android_directory = os.environ.get('ANDROID_DIR', '')
    if not android_directory:
        print("ANDROID_DIR environment variable not set")
        exit(1)
    duplicates = find_duplicate_package_list_classes(android_directory)
    if duplicates:
        print("Duplicate PackageList.java files found:")
        for duplicate in duplicates:
            print(duplicate)
    else:
        print("No duplicate PackageList.java files found.")